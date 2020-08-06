package trachuk.vadim.projects.webpageparser;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class WebPageParser {
    public static final int MAX_ARGS_LENGTH = 1;

//    protected static final String URL_PATTERN = "^(((((HTTP?|HTTPS?|http?|https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" + "(%[0-9A-Fa-f]{2}|[-()_.!~*';/?:@&=+$,A-Za-z0-9])+)" + "([).!';/?:,][[:blank:]]))?$";
    protected static final String URL_PATTERN = "((https?|ftp|file):|href\\s*=\\s*)//([-a-zA-Z0-9+&@#/%?=~_|!:,.;]+[-a-zA-Z0-9+&@#/%=~_|])";
//    public static final String URL_PATTERN = "^((@)?)|((http:)?)|((https:)?)|((HTTP:)?)|((HTTPS:)?)[//]?([a-zA-Z_0-9]+[а-яА-Я]+)?([.])?([a-zA-Z_0-9]+[а-яА-Я]+[/]?)([:][0-9]+)?([/]?[а-яА-Я]+[#&\n._=-~:/?@!$'()*+,;\\w]*)+?$";//;-=?+%.+
    private InputStream urlInputStream;
    private String url;
//"^(@)?(href=')?(HREF=')?(HREF=\")?(href=\")(http://)?(https://)?(HTTP://)?(HTTPS://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+[/]?)([:][0-9]+)?([/]?[#&\\n\\-=?+%.\\w]+)+?$"
//"^(href=')?(HREF=')?(HREF=\")?(href=\")?(http://)?(https://)?(HTTP://)?(HTTPS://)?([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+)?([.])([a-zA-Z_0-9]+[/]?)([:][0-9]+)?([/]?[#&\\n\\-=?+%.\\w]+)+?"
    public WebPageParser(String url) throws Exception {
         this.url = url;
        Validate validateURL = new Validate(url);
        validateURL.isMainUrlMatch();
        this.urlInputStream = new URL(url).openStream();
    }

    public  WebPageParser(String url, InputStream urlInputStream) {
        this.url = url;
        this.urlInputStream = urlInputStream;
    }

    public WebPageParser() {
    }

    //main method
    public static void main(String[] args) throws Exception {
        if (args != null && args.length == MAX_ARGS_LENGTH) {
            WebPageParser webPageParser = new WebPageParser(args[0]);


            List<DomainInfo> domainInfos = webPageParser.getDomainInfos();
            for (DomainInfo domainInfo : domainInfos) {

                System.out.println("URLInfo = " + domainInfo + "\n");

            }
        } else {
            System.out.println("wrong number of param. max valuable args count is " + MAX_ARGS_LENGTH);
        }
    }

    public List<DomainInfo> getDomainInfos() throws Exception {
        List<DomainInfo> domainInfos = new LinkedList<>();
        InetAddress ip = InetAddress.getByName(new URL(url).getHost());
        System.out.println("Public IP Address of: " + ip);

        MyParser myParser = new MyParser(urlInputStream);
        List<String> list = myParser.getHtmlLinks(url);
        DomainInfoGenerator domainInfoGenerator = new DomainInfoGenerator();

        for (String currentUrl : list) {
            DomainInfo domainInfo = domainInfoGenerator.create(currentUrl);
            domainInfos.add(domainInfo);
        }

        return domainInfos;
    }

}


