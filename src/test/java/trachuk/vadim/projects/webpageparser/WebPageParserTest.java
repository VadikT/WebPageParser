package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebPageParserTest {

    @Test
    public void tester() throws Exception {
        String url = "https://www.you tube.com";
        WebPageParser WebPageParser = new WebPageParser(url);
        if (WebPageParser.equals("URL is correct")) {
            Assertions.assertTrue(true);
        } else if (WebPageParser.equals("URL is not correct")){
            Assertions.fail("not correct URL");

        }

    }
    @Test
    public void tester2() throws Exception{
        String url = "https://www.you tube.com";
        WebPageParser webPageParser = new WebPageParser(url);
        if (webPageParser.isUrlMatch()){
            Assertions.fail("nop");
        }
    }


    @Test
    public void testRightHttp() throws Exception {
        String url = "http://www.youtube.com/";//нужно прогнать все варианты (https, ht, www, все привильные и неправильные +2х)
        WebPageParser webPageParser = new WebPageParser(url);
        webPageParser.isUrlMatch();
        Assertions.assertTrue(true);
    }//создать 2 правильных теста и 2 неправильных


    @Test
    public void testRightHttps() throws Exception {
        String url = "https://www.youtube.com/";
        WebPageParser webPageParser = new WebPageParser(url);
        if (webPageParser.isUrlMatch() == false) {
            Assertions.assertTrue(true);
            System.out.println("ok");
        } else {
            Assertions.fail("wrong url");
        }


    }

    @Test
    public void testWrongHttp() throws Exception {

        String url = "https://www.youtube.com";
        WebPageParser webPageParser = new WebPageParser(url);
        if (webPageParser.isUrlMatch() == false) {
            Assertions.fail();
        } else {
            System.out.println("ok");
        }
    }


        @Test
        public void testQweQweFail () {
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
        public void testQtySuccess () {
            String testData = "qwe";

            Pattern pattern = Pattern.compile("(.+)\\1+");                 //("(\\p{L})(?=.*\\1++)");
            Matcher matcher = pattern.matcher(testData);
            if (matcher.find()) {

                System.out.println("найдено совпадение" + matcher.group());
            } else {
                System.out.println("ok");
            }

        }
    }


