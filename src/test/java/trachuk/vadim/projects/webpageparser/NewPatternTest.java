package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewPatternTest {

    String pattern = "(?:\\?[!$&'()*+,.0-9=_a-z-]*)?";

    @Test
    public void testTogether3(){
        Pattern pattern = Pattern.compile("(!$)");
        Matcher matcher =pattern.matcher("aa");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void testTogether2(){
        Pattern pattern = Pattern.compile("(!$?)");
        Matcher matcher =pattern.matcher("!\n");
        Assertions.assertEquals(true, matcher.matches());
    }


    @Test
    public void testTogether1(){
        Pattern pattern = Pattern.compile("(:\\?)");
        Matcher matcher =pattern.matcher(":\\?");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test1R(){
        Pattern pattern = Pattern.compile("(a?)");
        Matcher matcher =pattern.matcher("a");
        Assertions.assertEquals(true, matcher.matches());
    }
    @Test
    public void test1N(){
        Pattern pattern = Pattern.compile("(a?)");
        Matcher matcher =pattern.matcher("aa");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test2R(){
        Pattern pattern = Pattern.compile(":");
        Matcher matcher =pattern.matcher(":");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test2N(){
        Pattern pattern = Pattern.compile(":");
        Matcher matcher =pattern.matcher("/");
        Assertions.assertEquals(false, matcher.matches());
    }
////////////////////////////////////////////////////////////
    @Test
    public void test3R(){
        Pattern pattern = Pattern.compile("(\\?)");
        Matcher matcher =pattern.matcher("\\?");
        Assertions.assertEquals(false, matcher.matches());
    }
/////////////////////////////////////////////////////////
@Test
public void test4R(){
    Pattern pattern = Pattern.compile("(a?)");
    Matcher matcher =pattern.matcher("a");
    Assertions.assertEquals(true, matcher.matches());
}
    @Test
    public void test4N(){
        Pattern pattern = Pattern.compile("(a?)");
        Matcher matcher =pattern.matcher("aa");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test5R(){
        Pattern pattern = Pattern.compile("!$");
        Matcher matcher =pattern.matcher("!");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test5N(){
        Pattern pattern = Pattern.compile("!$");
        Matcher matcher =pattern.matcher("a");
        Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test6R(){
        Pattern pattern = Pattern.compile("(&')");
        Matcher matcher =pattern.matcher("&'");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test6N(){
        Pattern pattern = Pattern.compile("(&')");
        Matcher matcher =pattern.matcher("a");
        Assertions.assertEquals(false,  matcher.matches());
    }

    @Test
    public void test7R(){
        Pattern pattern = Pattern.compile("[?]");// но если поменять на () то непонятно
        Matcher matcher = pattern.matcher("?");
        Assertions.assertEquals(true, matcher.matches());
    }

    @Test
    public void test7N(){
        Pattern pattern = Pattern.compile("[?]");
        Matcher matcher = pattern.matcher("");
     Assertions.assertEquals(false, matcher.matches());
    }

    @Test
    public void test8R(){
        Pattern pattern = Pattern.compile("[//]");
        Matcher matcher = pattern.matcher("/");
        Assertions.assertEquals(true, matcher.matches());

    }

    @Test
    public void test8N(){
        Pattern pattern = Pattern.compile("[//]");
        Matcher matcher = pattern.matcher("//");
        Assertions.assertEquals(false, matcher.matches());

    }


    @Test
    public void test9R(){
        Pattern pattern = Pattern.compile("(//)");
        Matcher matcher = pattern.matcher("//");
        Assertions.assertEquals(true, matcher.matches());

    }
    @Test
    public void test9N(){
        Pattern pattern = Pattern.compile("(!$?)");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(false, matcher.matches());

    }


}
