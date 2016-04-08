import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyFileReaderImpl implements MyFileReader {

    @Override
    public String getBodyFromFile(File file) throws IOException {
        String result = "";
        int i;
        FileInputStream fileOutputStream = new FileInputStream(file);
        while ((i = fileOutputStream.read()) != -1) {
            result += (char)i;
        }
        fileOutputStream.close();
        return result;
    }
}
