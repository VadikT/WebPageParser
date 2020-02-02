package trachuk.vadim.projects.webpageparser;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebPageParser {
    private final String url;
    public static final int MAX_ARGS_LENGTH = 1;
    private final String URL_PATTERN = "(@)?(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?[a-zA-Z_0-9\\-]+(\\.\\w[a-zA-Z_0-9\\-]+)+(/[#&\\n\\-=?\\+\\%/\\.\\w]+)?";


    public static void main(String[] args) throws Exception, RuntimeException {
        if (args != null && args.length == MAX_ARGS_LENGTH) {
            WebPageParser webPageParser = null;
            webPageParser = new WebPageParser(args[0]);
            try {
                webPageParser.parse();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("wrong number of param. max valiable args count is " + MAX_ARGS_LENGTH);
        }
    }


    public WebPageParser(String url) throws Exception {
        this.url = url;
        isUrlMatch();
        //перенасти в отдельный метод+
        // проверить с regexp что это именно 1 url и выкинуть ексепшн если не url if+-
    }

    public boolean isUrlMatch() throws WrongUrlParamException {
        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches() == true) {
            return matcher.matches();
        } else {
            return false;
        }

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
}

