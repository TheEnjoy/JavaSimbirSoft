import org.jsoup.Jsoup;

public class StringUtils {
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
}
