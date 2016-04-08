import java.io.File;
import java.io.IOException;

public interface MyFileReader {
    String getBodyFromFile(File file) throws IOException;
}
