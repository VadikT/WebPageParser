package trachuk.vadim.projects.webpageparser;

import java.io.*;
import java.net.*;
import java.util.regex.Pattern;


public class DomainInfoGenerator {
    public DomainInfoGenerator() throws Exception {
    }

    public boolean pingHost(String host, int port, int timeout) throws MalformedURLException {
        WebPageParser webPageParser = new WebPageParser();

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), timeout);

            return true;
        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }
    }

    public DomainInfo create(String currentUrl) throws Exception {
        Validate validate = new Validate(currentUrl);
        if (!validate.isMainUrlMatch()) {
            DomainInfo wrongUrlInfo = new DomainInfo.Builder()
                    .withDomainUrl(new URL(currentUrl))
                    .withIsWrongUrl(true)
                    .build();

            return wrongUrlInfo;
        }

        URL url = new URL(currentUrl);
        String dnsName = getDNSName(currentUrl);

        DomainInfo info = new DomainInfo.Builder()
                .withDomainUrl(url)
                .withDomainDNSName(dnsName)
                .withPort(getPort(url))
                .withDomainIp(getIpAddressByDNSName(dnsName))
                .withContentSize(getContentSize(url))
                .withIsPortAvailable(pingHost(dnsName, getPort(url), 3000))
                .build();

        return info;
    }

    private int getPort(URL url) {
        String pattern = "([:]?[0-9]+)";
        int port = 0;

        if (url.getProtocol().equals("http")) {
            port = 80;
        } else if (url.getProtocol().equals("https")) {
            port = 443;
        } else if (url.getProtocol().matches(pattern)) {
            port = 1;
        }

        return port;
    }


    public long getContentSize(URL url) throws IOException {

        byte[] dataBuffer = new byte[1024];

        long contentSize = 0;
        long readBytesCount = 0;
        BufferedInputStream inputStream = new BufferedInputStream(url.openStream());
        try {
            while ((readBytesCount = inputStream.readNBytes(dataBuffer, 0, dataBuffer.length)) != 0) {
                contentSize = contentSize + readBytesCount;

            }
        } finally {
            inputStream.close();
        }
        return contentSize;
    }


    //Its ok
    InetAddress getIpAddressByDNSName(String dnsName) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(dnsName);
        return inetAddress;
    }

    //Its ok
    String getDNSName(String url) throws MalformedURLException {
        URL getDnsName = new URL(url);
//        getDnsName.getPort();
//        Pattern pattern = Pattern.compile(":" +" [0-9]");
//        Matcher matcher = pattern.matcher(url);
//        if (matcher.matches()){
////            getDnsName.getDefaultPort();
//            matcher.group();
//            getDnsName.getHost();
//            }
//        return String.valueOf(getDnsName);
        return getDnsName.getHost();
    }


}


