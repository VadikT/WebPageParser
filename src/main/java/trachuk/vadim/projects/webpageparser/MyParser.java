package trachuk.vadim.projects.webpageparser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static trachuk.vadim.projects.webpageparser.WebPageParser.URL_PATTERN;

public class MyParser {
    private InputStream inputStream;
    private URL currentUrl;

    public MyParser(InputStream inputStream) throws Exception {
        this.inputStream = inputStream;
    }

    public MyParser(URL currentUrl) {
        this.currentUrl = currentUrl;
    }

    public String getHtmlContent() throws IOException {
        StringBuilder getHtmlPage = new StringBuilder();
        LineNumberReader reader = new LineNumberReader(new InputStreamReader(this.inputStream));
        String line;
        while ((line = reader.readLine()) != null) {

            getHtmlPage.append(new String(line.getBytes("Cp1251"), "UTF-8"));
        }

        reader.close();
        return getHtmlPage.toString();
    }


    public List<String> getHtmlLinks(String url) throws IOException {
        String htmlPage = getHtmlContent();

        List<String> list = new ArrayList<String>();
      String htmlRegex = URL_PATTERN;
//      String htmlRegex = "((https?|ftp|file):|href\\s*=\\s*)//([-a-zA-Z0-9+&@#/%?=~_|!:,.;]+[-a-zA-Z0-9+&@#/%=~_|])";
        Pattern htmlPattern = Pattern.compile(htmlRegex);
        Matcher htmlMatcher = htmlPattern.matcher(htmlPage);
        while (htmlMatcher.find()) {
            list.add(htmlMatcher.group());
        }
        return list;
    }
}
