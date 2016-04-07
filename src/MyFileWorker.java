import java.io.File;
import java.io.IOException;

public interface MyFileWorker {
    String getBodyFromFile(File file) throws IOException;
    void writeFile(File file, String s) throws IOException;
}
