package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QwePortTest {

    @Test
    public void testqweHttpsP() {

        String testData = "https://qwe.qwe.qwe:777";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testqwe2FalseHTTPS() {

        String testData = "HTTPS://qwe.qwe.qwe:777";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testqwe3HttpP() {

        String testData = "http://qwe.qwe.qwe:777";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testqwe4FailMissed_T_inUrl() {

        String testData = "htps://qwe.qwe.qwe:777";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testqwe5FailMissedSlash() {

        String testData = "https:/qwe.qwe.qwe:777";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testqwe6UpperCase() {

        String testData = "http://QWe.qwE.qWe:777";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testqwe7WithoutPort() {

        String testData = "http://qwe.qwe.qwe";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +


                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testqwe7WithoutNumbersOfPort() {

        String testData = "http://qwe.qwe.qwe:";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testqwe8ContinueAfterPort() {

        String testData = "http://qwe.qwe.qwe:777/qwe";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testqwe9WithOtherSymbols() {

        String testData = "http://qwe.qwe.qwe:777/asd-qw_fas-432&E(";

        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testqwe() {
        String testData = "http://qwe.qwe:777";
        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testqweUrlHard() {
        String testData = "http://qwe.qwe:777/dsaf-43-fsdf(ds)/fdsk/sdankgna.file";
        Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        Assertions.assertEquals(true, matcher.matches());
    }

}
