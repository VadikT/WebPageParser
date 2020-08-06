package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlTest {
    @Test
    public void testUrlPatternHTTPS() {
        String url = "https://";
        Pattern pattern = Pattern.compile("^(https://)$");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternHTTPS() {
        String url = "https";
        Pattern pattern = Pattern.compile("^(https://)$");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testUrlPatternHTTP() {
        String url = "http://";
        Pattern pattern = Pattern.compile("^(http://)");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternHTTP() {
        String url = "htp://";
        Pattern pattern = Pattern.compile("^(http://)");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testUrlPatternWWW() {
        String url = "https://qwe";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-z]+)");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternWWW() {
        String url = "https://qwe3";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-z]+)");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }


    @Test
    public void testUrlPatternHostName() {
        String url = "https://www.youtube8787";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)([.])([a-zA-Z_0-9]+)");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternHostName() {
        String url = "https://www.youtube8787:";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)([.])([a-zA-Z_0-9]+)");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testUrlPatternDomain() {
        String url = "https://www.youtube8787.com";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)([.])([a-zA-Z_0-9]+)([.])([a-zA-Z_0-9]+)");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternDomain() {
        String url = "https://www.youtube8787.com/";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)([.])([a-zA-Z_0-9]+)([.])([a-zA-Z_0-9]+)");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testUrlPatternAddPort() {
        String url = "https://www.youtube.com:787";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)([:][0-9]+)?");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternAddPort() {
        String url = "https://www.youtube.com:898:89";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)([:][0-9]+)?");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrl() {
        String url = "https://www.youtube.com/ejwk/klk/njknk/hnjnk";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternFullUrl() {
        String url = "https://www.yout ube.com/ejwk/klk/njknk/hnjnk";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrlWithNumbers() {
        String url = "https://www.youtube.com/ejwk/klk/n564jknk/hnjnk456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    ////////////////////////////////////////////////////////////
    @Test
    public void negativeTestUrlPatternFullUrlWithNumbers() {
        String url = "https://www.youtube.com/ejwk/klk/n564jknk/hnjnk456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    //////////////////////////////////////////////////////
    @Test
    public void testUrlPatternFullUrlWith_() {
        String url = "https://www.youtube.com/ejwk/kl_k/n56_4jknk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternFullUrlWith_() {
        String url = "https:/www.youtube.com/ejwk/kl_k/n56_4jknk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrlWithDefis() {
        String url = "https://www.youtube.com:787/ej-wk/kl_k/n56_4jk-nk/h-njn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternFullUrlWithDefis() {
        String url = "HTTPS://www.youtube.com:787/ej-wk/kl_k/n56_4jk-nk/h-njn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrlWithShift90() {
        String url = "https://www.youtube.com/ejwk/kl_k/n56_4(jk)nk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTstUrlPatternFullUrlWithShift90() {
        String url = "https://www.you tube.com/ejwk/kl_k/n56_4(jk)nk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrlWithRavmo() {
        String url = "https://www.youtube.com/ejwk/kl_k/n56_4j=knk/h=njn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    //////////////////////
    @Test
    public void negativeTestUrlPatternFullUrlWithRavmo() {
        String url = "https://www.youtube.com////ejwk/kl_k/n56_4j=knk/h=njn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)[/]?([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrlWithRussian() {
        String url = "https://www.youtube.com/ejыфалаwk/фыаkl_k/n56_4jknk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void negativeTestUrlPatternFullUrlWithRussian() {
        String url = "https://www.youtube.com/ejыфалаwk/фыаkl_k/n56_4jknk//hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrlWithOperandFail() {
        String url = "https://www.youtube.com/ejw&k/kl_k/n56_4jknk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrlWithUpperCase() {
        String url = "https://www.youtube.com/EFXk/kl_k/n56_4jknk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test

    public void testUrlPatternFullUrlWithDvoetochie() {
        String url = "https://www.youtube.com/ej:wk/-kl_k/n56_4jknk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrlUpperCaseHTTPS() {
        String url = "HTTPS://www.youtube.com/ej:wk/-kl_k/n56_4jknk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?(HTTP://)?(HTTPS://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9/]+)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testUrlPatternFullUrlUpperCaseHTTP() {
        String url = "HTTP://www.youtube.com/ej :wk/-kl_k/n56_4jknk/hnjn_k456";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?(HTTP://)?(HTTPS://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+[/]?)([:][0-9]+)?([a-zA-Z_0-9]\\d*\\D*)*");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testUrlPattern() {
        String url = "https://docs.google.com/spreadsheets/d/1qMOUJdaatAaQwo14gnPPbbbo_PL2f_5-mTbIfUBaD2c//edit#gid=760090596";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?(HTTP://)?(HTTPS://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+[/]?)([:][0-9]+)?(/[#&\\n\\-=?\\+\\%/\\.\\w]+)+?");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }



    @Test
    public void testUrlPatternNew() {
        String url = "https://docs.google.com/spreadsheets/d/1qMOUJdaatAaQwo14gnPPbbbo_PL2f_5-mTbIfUBaD2c/edit#gid=760090596";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?(HTTP://)?(HTTPS://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+[/]?)([:][0-9]+)?(/[#&\\n\\-=?\\+\\%/\\.\\w]+)+?");
        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }
    @Test
    public void ntestUrlPatter1n() {
        String url = "https://https://docs.google.com/spreadsheets/d/1qMOUJdaatAaQwo14gnPPbbbo_PL2f_5-mTbIfUBaD2c/edit#gid=760090596";
        Pattern pattern = Pattern.compile("^(http://)?(https://)?(HTTP://)?(HTTPS://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+[/]?)([:][0-9]+)?([/]?[#&\\n\\-=?+%.\\w]+)+?");

        Matcher matcher = pattern.matcher(url);
        Assertions.assertEquals(true, matcher.matches());
    }
}
                                                                                                                                                        /*\\w- соответствует слову(может состоять из букв,
                        (?:/[!$'()*+,.0-9_a-z-]*)?(?:\?[!$&'()*+,.0-9=_a-z-]*)?                                                                                                                                цифр и _)
                                                                                                                                                        \\n - новая строка

                                                                                                                                                        */