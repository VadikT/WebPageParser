package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoPatternTest {

    @Test
    public void testWebPageParserPattern() {
        Pattern pattern = Pattern.compile("^(((((HTTP?|HTTPS?|http?|https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))\" + \"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)\" + \"([).!';/?:,][[:blank:]]))?$");

        Matcher matcher = pattern.matcher("https://i.ytimg.com/vi/h64Hk0Vzkwg/hqdefault.jpg?sqp=-oaymwEiCMQBEG5IWvKriqkDFQgBFQAAAAAYASUAAMhCPQCAokN4AQ==&amp;rs=AOn4CLBh5ht85zeHEMwD8zBLZWRfM83Hlw");

        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testMyParserPattern() {
        Pattern pattern = Pattern.compile("((https?|ftp|file):|href\\s*=\\s*)//([-a-zA-Z0-9+&@#/%?=~_|!:,.;]+[-a-zA-Z0-9+&@#/%=~_|])");

        Matcher matcher = pattern.matcher("https://i.ytimg.com/vi/h64Hk0Vzkwg/hqdefault.jpg?sqp=-oaymwEiCMQBEG5IWvKriqkDFQgBFQAAAAAYASUAAMhCPQCAokN4AQ==&amp;rs=AOn4CLBh5ht85zeHEMwD8zBLZWRfM83Hlw");

        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("WebPageParserResourse.html");
        WebPageParser webPageParser = new WebPageParser("https://www.ghisler.com/download.htm", resourceAsStream);//
        Pattern pattern = Pattern.compile("^(((((HTTP?|HTTPS?|http?|https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))\" + \"(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)\" + \"([).!';/?:,][[:blank:]]))?$");
//    Matcher matcher = pattern.matcher("https://i.ytimg.com/vi/h64Hk0Vzkwg/hqdefault.jpg?sqp=-oaymwEiCMQBEG5IWvKriqkDFQgBFQAAAAAYASUAAMhCPQCAokN4AQ==&amp;rs=AOn4CLBh5ht85zeHEMwD8zBLZWRfM83Hlw");
        List<DomainInfo> domainInfos = webPageParser.getDomainInfos();

        Assertions.assertEquals(23, domainInfos.size());

        DomainInfo domainInfo = domainInfos.get(0);

        Assertions.assertEquals("www.ghisler.com/download.htm", domainInfo.getDnsName());
        Assertions.assertEquals(false, domainInfo.isWrongUrl());
        Assertions.assertEquals(true, domainInfo.isPingHost());
        Assertions.assertEquals(new URL(""), domainInfo.getDomainIp());
        Assertions.assertEquals(new URL("https://www.youtube.com/"), domainInfo.getDomainUrl());
        Assertions.assertEquals(260006, domainInfo.getContentSize());
        Assertions.assertEquals(443, domainInfo.getPort());


        Assertions.assertEquals("", domainInfos.get(0).getDomainUrl());
        Assertions.assertEquals("", domainInfos.get(1).getDomainUrl());
        Assertions.assertEquals("", domainInfos.get(2).getDomainUrl());
        Assertions.assertEquals("", domainInfos.get(3).getDomainUrl());//23
    }
}
