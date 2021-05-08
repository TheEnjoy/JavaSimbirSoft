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
        LOGGER.log(Level.INFO,"Начало main, работаем");
        String httpsURL = "https://www.simbirsoft.com";
         httpsURL = "";
        String fileName = "filename12.html";
        HashMap<String, Integer> result = new HashMap<>();
        HttpsClientUtil httpsClientUtil = new HttpsClientUtil();
        Boolean downloadFileOK = false;
        try {
            downloadFileOK = httpsClientUtil.downloadHtmlByUrlAndSaveToPath(httpsURL,".", fileName);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception: ", e);
//            e.printStackTrace();
        }
        if(downloadFileOK){
            LOGGER.log(Level.INFO,"Html загружен, работаем");
            FileReader fileReader = new FileReader();
            result = fileReader.readFile(fileName);
//            System.out.println(result);
            LOGGER.log(Level.INFO, result.toString());
        }
    }


//    public void test() throws IOException, InterruptedException
//    {
//        File words = new File("resources" + File.separator + "AV1611Bible.txt");
//
//        if (!words.exists())
//        {
//            System.out.println("File [" + words.getAbsolutePath()
//                    + "] does not exist");
//        }
//
//        WordContainer container = new WordContainer();
//
//        Semaphore s = new Semaphore(0);
//        Semaphore s2 = new Semaphore(0);
//
//        Reader reader = new Reader(words, container, s, s2);
//        Sorter sorter = new Sorter(container, s, s2);
//
//        reader.startReading();
//        sorter.startSorting();
//
//        reader.join();
//        sorter.join();
//
//        System.out.println(reader.getWords());
//
//        /*
//         * String bible = reader.getWords(); System.out.println(bible); String[]
//         * bible2 = sorter.getSortedWords(); System.out.println(bible2);
//         * assertTrue(bible2.length < bible.length());
//         */
//    }
}

