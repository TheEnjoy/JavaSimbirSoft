import org.jsoup.Jsoup;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Logger;

public class StringUtils {

    private static final String URL_PATTERN =
            "/^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*))?(#(.*))?/";

//    public static String deletedHtmlTags(String htmlLine) {
//        //return htmlLine.replaceAll("(?i)<*[^>]*>", " ").replaceAll("\\s+", " ").trim();
//        return htmlLine.replaceAll("<[^>]*>", "").trim();
//    }

    public static String deletedHtmlTags(String htmlLine) {
        return Jsoup.parse(htmlLine).text();
    }

    public static boolean validChar(char c) {
        return Character.isAlphabetic(c);
    }

    public static boolean isWhiteSpace(char nextChar) {
        switch (nextChar) {
            case '-':
            case '"':
            case ':':
            case '\'':
            case ')':
            case '(':
            case '!':
            case ']':
            case '?':
            case '.':
            case ',':
            case ';':
            case '[':
            case ' ':
            case '\t':
            case '\n':
            case '\r':
                return true;
        }
        return false;
    }

    public static final Boolean validateURL(String url, Logger logger) {
        URL u = null;
        boolean valid = false;
        try {
            Pattern regex = Pattern.compile(URL_PATTERN);
            Matcher matcher = regex.matcher(url);
            if (!matcher.find()) {
                throw new URISyntaxException(url, "Error for URL");
            }
            u = new URL(url);
            u.toURI();
            valid = true;
        } catch (MalformedURLException | URISyntaxException e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }
        return valid;

    }
}
