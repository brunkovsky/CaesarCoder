import java.io.File;
import java.io.IOException;

public interface MyFileWriter {
    void writeFile(File file, String s) throws IOException;
}
