package trachuk.vadim.projects.webpageparser;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebPageParser {
    private final String url;
    public static final int MAX_ARGS_LENGTH = 1;
    //private final String URL_PATTERN = "^(http:\\/\\/|https:\\/\\/)?(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?$";
    private final String URL_PATTERN = "(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?(https://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?";

//main method
    public static void main(String[] args) throws Exception, RuntimeException {
        if (args != null && args.length == MAX_ARGS_LENGTH) {

            WebPageParser webPageParser = null;
            webPageParser = new WebPageParser(args[0]);
            try { webPageParser.isUrlMatch();
                webPageParser.parse();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            webPageParser.getIpAdrress();
            //webPageParser.isPortAwailible(url, 80);
        } else {
            System.out.println("wrong number of param. max valiable args count is " + MAX_ARGS_LENGTH);
        }
    }


    public WebPageParser(String url) throws Exception {
        this.url = url;
       // isUrlMatch();
       // getIpAdrress();
       // isPortAwailible(url, 80);
        //перенасти в отдельный метод+
        // проверить с regexp что это именно 1 url и выкинуть ексепшн если не url if+-
    }


    //method that validates URL
    public boolean isUrlMatch() throws WrongUrlParamException {
        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches() == true){
            System.out.println("URL is correct");
        }else if (matcher.matches() == false){
            System.out.println("URL is not correct");

        }
        return true;
    }


    public List<DomainInfo> parse() throws IOException {
        LinkedList<DomainInfo> list = new LinkedList<>();

        URL webPageUrl = new URL(this.url);
        //прочитать по Url весь контент в сторку+
        //реализовать сам parse
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(webPageUrl.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuffer stringBuffer = new StringBuffer();


        String line = null;
        while (true) {

            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.out.println(line);

            stringBuffer.append(line).append("\n");

        }
        try {
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return list;
    }
        //method witch cheks ip address by host
/*
    public String getIpAdrress(int port) throws UnknownHostException {

        String getAllIp = null;

        InetAddress[] ipList = new InetAddress[0];

        ipList = InetAddress.getAllByName(url);

        for (InetAddress address : ipList){
            getAllIp = address.getHostAddress();
        }
        System.out.println(getAllIp);

     return getAllIp;
    }*/


//method witch cheks ip address by host
        public String getIpAdrress() throws IOException {
            InetAddress ip = InetAddress.getByName(new URL(this.url)
                    .getHost());
            System.out.println("Public IP Address of: " + ip);

            return String.valueOf(ip);
        }

    //method witch cheks port
    public static boolean isPortAwailible(String hostName, int port) {

        boolean isAlive = false;

        // Creates a socket address from a hostname and a port number
        SocketAddress socketAddress = new InetSocketAddress(hostName, port);
        Socket socket = new Socket();

        // Timeout required - it's in milliseconds
        int timeout = 2000;

        log("hostName: " + hostName + ", port: " + port);
        try {
            socket.connect(socketAddress, timeout);
            socket.close();
            isAlive = true;

        } catch (SocketTimeoutException exception) {
            System.out.println("SocketTimeoutException " + hostName + ":" + port + ". " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println(
                    "IOException - Unable to connect to " + hostName + ":" + port + ". " + exception.getMessage());
        }
        System.out.println(isAlive);
        return isAlive;
    }

    // Simple log utility
    private static void log(String string) {
        System.out.println(string);
    }

    // Simple log utility returns boolean result
    private static void log(boolean isAlive) {
        System.out.println("isAlive result: " + isAlive + "\n");
    }


}

