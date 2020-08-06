package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;

import java.io.InputStream;
import java.util.List;

public class PatternTestFromResourses {

    public PatternTestFromResourses() throws Exception {

        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("WebPageParserResourse.html");
        WebPageParser webPageParser = new WebPageParser("https://www.ghisler.com/download.htm", resourceAsStream);//
        List<DomainInfo> domainInfos = webPageParser.getDomainInfos();

        Assertions.assertEquals(23, domainInfos.size());

        DomainInfo domainInfo = domainInfos.get(0);


    }
}
