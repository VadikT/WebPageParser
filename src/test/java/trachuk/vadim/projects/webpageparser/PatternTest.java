package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {
    String regexpPattern = "(?:/[!$'()*+,.0-9_a-z-]*)?(?:\\?[!$&'()*+,.0-9=_a-z-]*)?";


    @Test
    public void testTogether2() {

        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(true, matcher.matches());
    }


    @Test
    public void testTogether1() {

        Pattern pattern = Pattern.compile("(?:)");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(true, matcher.matches());
    }



    @Test
    public void test1() {

        Pattern pattern = Pattern.compile("()");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test1False() {

        Pattern pattern = Pattern.compile("()");
        Matcher matcher = pattern.matcher("a");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test2() {

        Pattern pattern = Pattern.compile("(?)");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test2False() {

        Pattern pattern = Pattern.compile("(?)");
        Matcher matcher = pattern.matcher("aaaaaaa");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test3() {

        Pattern pattern = Pattern.compile(":");
        Matcher matcher = pattern.matcher(":");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test3False() {
/////////////////////////////////////
        Pattern pattern = Pattern.compile(":");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test4() {

        Pattern pattern = Pattern.compile("/");
        Matcher matcher = pattern.matcher("/");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test4False() {

        Pattern pattern = Pattern.compile("/");
        Matcher matcher = pattern.matcher("a/");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test5() {

        Pattern pattern = Pattern.compile("!");
        Matcher matcher = pattern.matcher("!");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test5False() {

        Pattern pattern = Pattern.compile("!");
        Matcher matcher = pattern.matcher("a");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test6() {

        Pattern pattern = Pattern.compile("$");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test6False() {

        Pattern pattern = Pattern.compile("$");
        Matcher matcher = pattern.matcher("a");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test7() {

        Pattern pattern = Pattern.compile("'");
        Matcher matcher = pattern.matcher("'");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test7False() {

        Pattern pattern = Pattern.compile("'");
        Matcher matcher = pattern.matcher("()");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test8() {

        Pattern pattern = Pattern.compile("a*");
        Matcher matcher = pattern.matcher("aaaaaaaa");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test8False() {

        Pattern pattern = Pattern.compile("a*");
        Matcher matcher = pattern.matcher("b");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test9() {

        Pattern pattern = Pattern.compile("a+");
        Matcher matcher = pattern.matcher("aaa");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test9False() {

        Pattern pattern = Pattern.compile("a+");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test10() {

        Pattern pattern = Pattern.compile(",");
        Matcher matcher = pattern.matcher(",");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test10False() {

        Pattern pattern = Pattern.compile(",");
        Matcher matcher = pattern.matcher("/");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test11() {

        Pattern pattern = Pattern.compile(".");
        Matcher matcher = pattern.matcher("&");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test11False() {

        Pattern pattern = Pattern.compile(".");
        Matcher matcher = pattern.matcher("&&");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test12() {

        Pattern pattern = Pattern.compile("-");
        Matcher matcher = pattern.matcher("-");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test12False() {

        Pattern pattern = Pattern.compile("-");
        Matcher matcher = pattern.matcher("_");
        Assertions.assertEquals(false, matcher.matches());
    }

//
//    @Test
//    public void test13() {
//
//        Pattern pattern = Pattern.compile("\\?");
//        Matcher matcher = pattern.matcher("\\?");
//        Assertions.assertEquals(true, matcher.matches());
//    }


    @Test
    public void test14() {

        Pattern pattern = Pattern.compile("(?:/)");
        Matcher matcher = pattern.matcher(":::://" +
                "/");
        Assertions.assertEquals(false, matcher.matches());
    }
    @Test
    public void test14False() {

        Pattern pattern = Pattern.compile("(?:/)");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(false, matcher.matches());
    }



}

