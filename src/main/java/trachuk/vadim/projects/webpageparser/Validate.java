package trachuk.vadim.projects.webpageparser;

import java.io.InputStream;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static trachuk.vadim.projects.webpageparser.WebPageParser.URL_PATTERN;

public class Validate  {


    private final String url;

    public Validate(String url) throws Exception {
        this.url = url;
    }

    public boolean isMainUrlMatch() throws WrongUrlParamException {

        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }


}
