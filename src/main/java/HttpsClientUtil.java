import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpsClientUtil {
    public boolean downloadHtmlByUrlAndSaveToPath(String url, String pathForSave, String fileNameForSave) throws Exception {
        String filePath = (pathForSave + File.separator + fileNameForSave);
        if(filePath.isEmpty() || url.isEmpty() || pathForSave.isEmpty()){
            throw new Exception("Некорректные данные");
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
        URL urlForDownload = new URL(url);
        HttpsURLConnection connection = (HttpsURLConnection) urlForDownload.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:63.0) Gecko/20100101 Firefox/63.0");
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String inputLine;
        // Write each line into the file
        while ((inputLine = bufferedReader.readLine()) != null) {
            System.out.println(inputLine);
            //toDO: Подумать над тем, чтобы убрать html tag, регэксп или Jsoup.
            // Сейчас это реализовано в StringUtils.deletedHtmlTags,
            // но Jsoup неадекватно удаляет теги.
            bufferedWriter.write(inputLine);
        }
        inputStreamReader.close();
        bufferedWriter.close();
        return FileUtils.checkIsFileExist(filePath);
    }
}
