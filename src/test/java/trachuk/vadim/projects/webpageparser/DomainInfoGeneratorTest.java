package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DomainInfoGeneratorTest {
    @Test
    public void createRight5ParamTest() throws Exception {
        String currentUrl = "https://accounts.google.com/ServiceLogin?uilel=3&amp;service=youtube&amp;passive=true&amp;hl=uk&amp;continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Ffeature%3Dsign_in_button%26hl%3Duk%26next%3D%252F%26action_handle_signin%3Dtrue%26app%3Ddesktop";
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();
        DomainInfo domainInfo = domainInfoGenerator.create(currentUrl);
        System.out.println(domainInfo);
        Assertions.assertNotNull(domainInfo);
        Assertions.assertEquals("https://accounts.google.com/ServiceLogin?uilel=3&amp;service=youtube&amp;passive=true&amp;hl=uk&amp;continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Ffeature%3Dsign_in_button%26hl%3Duk%26next%3D%252F%26action_handle_signin%3Dtrue%26app%3Ddesktop", domainInfo.getDomainUrl().toString());
//        Assertions.assertEquals("www.google.com", domainInfo.getDNSName(currentUrl);
        Assertions.assertEquals("www.youtube.com/172.217.16.46", domainInfo.getDomainIp().toString());
        Assertions.assertEquals(true, domainInfo.isPingHost());
        Assertions.assertEquals(561, domainInfo.getContentSize());
        Assertions.assertEquals(false, domainInfo.isWrongUrl());
        Assertions.assertEquals(443, domainInfo.getPort());
    }

    @Test
    public void getDnsNameByURLTest() throws Exception {
        String currentURL = "https://www.youtube.com/";
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();
        Assertions.assertEquals("www.youtube.com", domainInfoGenerator.getDNSName(currentURL));
    }

    @Test
    public void getIpAddressTest() throws Exception {
        String dnsName = "www.youtube.com";
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();
        System.out.println(domainInfoGenerator.getIpAddressByDNSName(dnsName));
        Assertions.assertEquals("www.youtube.com/216.58.215.110", domainInfoGenerator.getIpAddressByDNSName(dnsName).toString());
    }

    @Test
    public void pingHostTest() throws Exception {
        String url = "https://www.youtube.com";
        String host = "www.youtube.com/";
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();

        System.out.println(domainInfoGenerator.pingHost(host, 80, 5000));
    }

    @Test
    public void createRightParamTest() throws Exception {
        String currentUrl = "https://www.google.com/intl/ru/gmail/about/";
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();
        DomainInfo domainInfo = domainInfoGenerator.create(currentUrl);
        System.out.println(domainInfo);
        Assertions.assertNotNull(domainInfo);
        Assertions.assertEquals("https://www.google.com/intl/ru/gmail/about/", domainInfo.getDomainUrl().toString());
        Assertions.assertEquals("www.google.com", domainInfo.getDnsName());
        Assertions.assertEquals("www.google.com/216.58.215.100", domainInfo.getDomainIp().toString());
        Assertions.assertEquals(true, domainInfo.isPingHost());
        Assertions.assertEquals(67029, domainInfo.getContentSize());
        Assertions.assertEquals(false, domainInfo.isWrongUrl());
        Assertions.assertEquals(443, domainInfo.getPort());
    }

    @Test
    public void createRight2ParamTest() throws Exception {
        String currentUrl = "HTTPS://www.youtube.com/opensearch?locale=uk_UA";
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();
        DomainInfo domainInfo = domainInfoGenerator.create(currentUrl);
        System.out.println(domainInfo);
        Assertions.assertNotNull(domainInfo);
        Assertions.assertEquals("https://www.youtube.com/opensearch?locale=uk_UA", domainInfo.getDomainUrl().toString());
        Assertions.assertEquals("www.youtube.com", domainInfo.getDnsName());
        Assertions.assertEquals("www.youtube.com/172.217.16.46", domainInfo.getDomainIp().toString());
        Assertions.assertEquals(true, domainInfo.isPingHost());
        Assertions.assertEquals(561, domainInfo.getContentSize());
        Assertions.assertEquals(false, domainInfo.isWrongUrl());
        Assertions.assertEquals(443, domainInfo.getPort());
    }

    @Test
    public void createRight3ParamTest() throws Exception {

        String currentUrl = "https://www.youtube.com/opensearch?locale=uk_UA";
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();
        DomainInfo domainInfo = domainInfoGenerator.create(currentUrl);
        System.out.println(domainInfo);
        Assertions.assertNotNull(domainInfo);
        Assertions.assertEquals("https://www.youtube.com/opensearch?locale=uk_UA", domainInfo.getDomainUrl().toString());
        Assertions.assertEquals("www.youtube.com", domainInfo.getDnsName());
        Assertions.assertEquals("www.youtube.com/172.217.16.46", domainInfo.getDomainIp().toString());
        Assertions.assertEquals(true, domainInfo.isPingHost());
        Assertions.assertEquals(561, domainInfo.getContentSize());
        Assertions.assertEquals(false, domainInfo.isWrongUrl());
        Assertions.assertEquals(443, domainInfo.getPort());
    }

    @Test
    public void createRight4ParamTest() throws Exception {
        String currentUrl = "https://www.youtube.com/opensearch?locale=uk_UA";
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();
        DomainInfo domainInfo = domainInfoGenerator.create(currentUrl);
        System.out.println(domainInfo);
        Assertions.assertNotNull(domainInfo);
        Assertions.assertEquals("https://www.youtube.com/opensearch?locale=uk_UA", domainInfo.getDomainUrl().toString());
//        Assertions.assertEquals("www.google.com", domainInfo.getDNSName(currentUrl);
        Assertions.assertEquals("www.youtube.com/172.217.16.46", domainInfo.getDomainIp().toString());
        Assertions.assertEquals(true, domainInfo.isPingHost());
        Assertions.assertEquals(561, domainInfo.getContentSize());
        Assertions.assertEquals(false, domainInfo.isWrongUrl());
        Assertions.assertEquals(443, domainInfo.getPort());
    }

    @Test
    public void createWrongParamTest() throws Exception {
        String currentUrl = "https://www.youtube.com/opensearch?locale=uk_UA";
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();
        domainInfoGenerator.create(currentUrl);
    }


    @Test
    public void testSaveContent() throws Exception {
        URL currentUrl= new URL("www.youtube.com");
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();
        domainInfoGenerator.create(currentUrl.toString());
//        getSaveContent(currentUrl);
        getSaveContent(currentUrl);

    }

    public File getSaveContent(URL url) throws IOException {
//        final File file = new File(String.valueOf(File.createTempFile("ds", "s")));
        //создать темповый файл, и передать ему в параметр fileOutputStream
        File file = File.createTempFile("ContentFile", ".html");
        byte[] dataBuffer = new byte[1024];
//        File file1 = new File(String.valueOf(destinationFile));
        File destinationFile = new File(String.valueOf(file));

        if (!file.exists()) {
            file.createNewFile();

        }
        FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        long contentSize = 0;
        int readBytesCount = 0;
        BufferedInputStream inputStream = new BufferedInputStream(url.openStream());

        try {
            while ((readBytesCount = inputStream.readNBytes(dataBuffer, 0, dataBuffer.length)) != 0) {
                //bufferedWriter.write(String.valueOf(destinationFile));
//                bufferedWriter.write(String.valueOf(dataBuffer));
                fileWriter.write(String.valueOf(dataBuffer), 0, readBytesCount);


            }
        } finally {
            inputStream.close();
            bufferedWriter.close();
        }
        return destinationFile;
    }


}