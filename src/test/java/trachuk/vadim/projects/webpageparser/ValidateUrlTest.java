package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUrlTest {

    @Test
    public void test1() throws Exception {
        String url = "https://www.youtube.com/";
        Validate validate = new Validate(url);
        Assertions.assertEquals(true, validate.isMainUrlMatch());

    }

    @Test
    public void testHTTP() throws Exception {
        String url = "http://www.quizful.net/post/Java-RegExp";
        Validate validate = new Validate(url);
        Assertions.assertEquals(true, validate.isMainUrlMatch());
    }

    @Test
    public void testUrlUpperCase() throws Exception {
        String url = "HTTPS://www.quizful.net/post/Java-RegExp";
        Validate validate = new Validate(url);
        Assertions.assertEquals(true, validate.isMainUrlMatch());
    }

    @Test
    public void testUrlSpace() throws Exception {
        String url = "HTTPS://www.qui zful.net/post/Java-RegExp";
        Validate validate = new Validate(url);
        Assertions.assertEquals(false, validate.isMainUrlMatch());
    }

    @Test
    public void testUrlSpaceAfterDNS() throws Exception {
        String url = "HTTPS://www.quizful.net/post/Java- RegExp";
        Validate validate = new Validate(url);
        Assertions.assertEquals(false, validate.isMainUrlMatch());
    }


    @Test
    public void testUrlDobleSlash() throws Exception {
        String url = "https://www.quizful.net/post//Java-RegExp";
        Validate validate = new Validate(url);
        Assertions.assertEquals(false, validate.isMainUrlMatch());
    }


    @Test
    public void testUrlRuss() throws Exception {
        String url = "HTTPS://www.quizful.net/post/Javaжава-RegExp";
        Validate validate = new Validate(url);
        Assertions.assertEquals(true, validate.isMainUrlMatch());
    }

    @Test
    public void testUrlUpperCase2() throws Exception {
        String url = "HTTPS://www.Quizful.net/post/JAVA-RegExp";
        Validate validate = new Validate(url);
        Assertions.assertEquals(true, validate.isMainUrlMatch());
    }

    @Test
    public void testUrlNUMBERS() throws Exception {
        String url = "HTTPS://www.quizful.net/post/Java8-RegExp";
        Validate validate = new Validate(url);
        Assertions.assertEquals(true, validate.isMainUrlMatch());
    }
    @Test
    public void testUrlOnlyDNS() throws Exception {
        String url = "www.quizful.net/post/Java-RegExp";
        Validate validate = new Validate(url);
        Assertions.assertEquals(true, validate.isMainUrlMatch());
    }

    @Test
    public void testForMyPattern() throws Exception {
        String url = "https://i.ytimg.com/vi/FVa37f67Hnc/hqdefault.jpg?sqp=-oaymwEiCMQBEG5IWvKriqkDFQgBFQAAAAAYASUAAMhCPQCAokN4AQ==&amp;rs=AOn4CLBTUuRLEwmfw7klSNC6bCT5-AemjQ";
        Validate validate = new Validate(url);
        Assertions.assertEquals(true, validate.isMainUrlMatch());
    }















    @Test
        public void tester() throws Exception {
            String url = "https://www.youtube.com";
    //        String url = "https://www.you tube.com";
            WebPageParser WebPageParser = new WebPageParser(url);
            if (WebPageParser.equals("URL is correct")) {
                Assertions.assertTrue(true);
            } else if (WebPageParser.equals("URL is not correct")) {
                Assertions.fail("not correct URL");

            }

        }

        @Test
        public void tester2() throws Exception {

            String url = "https://www.yo utube.com";
            Validate validate = new Validate(url);
            if (validate.isMainUrlMatch()) {
                Assertions.fail("nop");
            }
        }
//:https://accounts.google.com/ServiceLogin?uilel=3&amp;service=youtube&amp;passive=true&amp;hl=uk&amp;continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Ffeature%3Dsign_in_button%26hl%3Duk%26next%3D%252F%26action_handle_signin%3Dtrue%26app%3Ddesktop

        @Test
        public void testRightHttp() throws Exception {
            String url = "https://www.youtube.com";
            Validate validate = new Validate(url);
            validate.isMainUrlMatch();
            Assertions.assertTrue(true);
        }//создать 2 правильных теста и 2 неправильных


        @Test
        public void testRightHttps() throws Exception {
            String url = "https://www.youtube.com";
            Validate validate = new Validate(url);
            if (validate.isMainUrlMatch()) {
                Assertions.assertTrue(true);
                System.out.println("ok");
            } else {
                Assertions.fail("wrong url");
            }


        }

        @Test
        public void testRight4DomainLevelHttps() throws Exception {
            String url = "https://www.youtube.com";
            Validate validate = new Validate(url);
            if (validate.isMainUrlMatch()) {
                Assertions.assertTrue(true);
                System.out.println("ok");
            } else {
                Assertions.fail("wrong url");
            }


        }

    @Test
    public void testWrongHttp() throws Exception {
        String url = "https://www.youtube.com";
        Validate validate = new Validate(url);
        if (validate.isMainUrlMatch()) {
            Assertions.assertTrue(true);
        } else {
            System.out.println("ok");
            Assertions.fail();
        }
    }


    @Test
    public void testQweQweFail() {
        String testData = "qweqwe";

        Pattern pattern = Pattern.compile("(.+)\\1+");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        if (matcher.find()) {

            System.out.println("найдено совпадение" + matcher.group());

        } else {
            System.out.println("ok");
        }


    }

    @Test
    public void testQweQweSuccess() {
        String testData = "qwe";

        Pattern pattern = Pattern.compile("(.+)\\1+");                 //("(\\p{L})(?=.*\\1++)");
        Matcher matcher = pattern.matcher(testData);
        if (matcher.find()) {

            System.out.println("найдено совпадение" + matcher.group());
        } else {
            System.out.println("ok");
        }

    }

    @Test
        public void testQwePortSuccess() {
            String testData = "http://qwe.qwe.qwe:777";

            Pattern pattern = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" +
                    "([).!';/?:,][[:blank:]])?$");                 //("(\\p{L})(?=.*\\1++)");
            Matcher matcher = pattern.matcher(testData);
            Assertions.assertEquals(true, matcher.matches());
    }
    @Test
    public void testRightHttpNew() throws Exception {
        String url = "https://accounts.google.com/ServiceLogin?uilel=3&amp;service=youtube&amp;passive=true&amp;hl=uk&amp;continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3Ffeature%3Dsign_in_button%26hl%3Duk%26next%3D%252F%26action_handle_signin%3Dtrue%26app%3Ddesktop";
        Validate validate = new Validate(url);

        Assertions.assertTrue(validate.isMainUrlMatch());
//        Assertions.assertEquals(validate.isMainUrlMatch());
    }//создать 2 правильных теста и 2 неправильных
}

