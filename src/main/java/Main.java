import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static Logger LOGGER;

    public static void main(String[] args) throws IOException {
        LOGGER = Logger.getLogger(Main.class.getName());
        LOGGER.log(Level.INFO, "Начало main, работаем");
        String fileName = "";
        String httpsURL = "";
        if (args.length != 0) {
            if (StringUtils.validateURL(args[0], LOGGER)) {
                if (!args[1].isEmpty()) {
                    httpsURL = args[0];
                    fileName = args[1];
                }
            }
        } else {
            fileName = "test.html";
            httpsURL = "https://www.simbirsoft.com";
        }
        HashMap<String, Integer> result = new HashMap<>();
        HttpsClientUtil httpsClientUtil = new HttpsClientUtil();
        Boolean downloadFileOK = false;
        try {
            downloadFileOK = httpsClientUtil.downloadHtmlByUrlAndSaveToPath(httpsURL, ".", fileName);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
        }
        if (downloadFileOK) {
            LOGGER.log(Level.INFO, "Html загружен, работаем");
            FileReader fileReader = new FileReader();
            result = fileReader.readFile(fileName);
            LOGGER.log(Level.INFO, result.toString());
        }
    }

}

