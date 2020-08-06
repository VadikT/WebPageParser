package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgainWritingPatternTest {

    @Test
    public void test1(){
        Pattern pattern = Pattern.compile("(a-zA-Z_0-9)*");
        Matcher matcher = pattern.matcher("");
        Assertions.assertEquals(true ,matcher.matches());
    }
    @Test
    public void test2(){
        Pattern pattern = Pattern.compile(" (http://)?|(https://)?" +
                "([a-zA-Z_0-9])?+[.]?" +
                "([a-zA-Z_0-9])+?[.]?" +
                "([a-zA-Z_0-9])?+");
        Matcher matcher = pattern.matcher("https://i.ytimg.com");
        Assertions.assertEquals(true ,matcher.matches());
    }

//https://i.ytimg.com/vi/Jc2OvGHMjzg/hqdefault.jpg?sqp=-oaymwEiCMQBEG5IWvKriqkDFQgBFQAAAAAYASUAAMhCPQCAokN4AQ==&amp;rs=AOn4CLCG1vsZ8LKr0KVXlJ-smGxMCG5Q-Q
}
