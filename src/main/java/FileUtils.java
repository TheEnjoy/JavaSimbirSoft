import java.io.File;

public class FileUtils {
    public static boolean checkIsFileExist(String filePath) {
        File f = new File(filePath);
        return f.exists() && !f.isDirectory();
    }
}
