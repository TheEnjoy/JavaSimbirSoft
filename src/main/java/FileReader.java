import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class FileReader {
    public HashMap<String, Integer> readFile(String fileName) {
        HashMap<String, Integer> words = new HashMap<>();
        java.io.FileReader fileReader = null;
        try {
            fileReader = new java.io.FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(Objects.requireNonNull(fileReader))) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                HashMap<String, Integer> finalWordsNew = CounterWords.countWords(line);
                words.forEach((k, v) -> finalWordsNew.merge(k, v, Integer::sum));
                words = finalWordsNew;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }
}
