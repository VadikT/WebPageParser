package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.stream.Stream;

public class WebPageParserTest {
    @Test
    public void test() throws Exception{
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("WebPageParserResourse.html");
        WebPageParser webPageParser = new WebPageParser("https://www.ghisler.com/download.htm", resourceAsStream);//
        List<DomainInfo> domainInfos = webPageParser.getDomainInfos();
        Assertions.assertEquals(23, domainInfos.size());

        DomainInfo domainInfo = domainInfos.get(0);

        Assertions.assertEquals("totalcommander.ch", domainInfo.getDnsName());
        Assertions.assertEquals(false, domainInfo.isWrongUrl());
        Assertions.assertEquals(true, domainInfo.isPingHost());
        Assertions.assertEquals(new URL("") ,domainInfo.getDomainIp());
        Assertions.assertEquals(new URL("https://www.youtube.com/"), domainInfo.getDomainUrl());
        Assertions.assertEquals(260006, domainInfo.getContentSize());
        Assertions.assertEquals(443, domainInfo.getPort());


    }
}
