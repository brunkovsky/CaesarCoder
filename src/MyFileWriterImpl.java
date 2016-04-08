import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileWriterImpl implements MyFileWriter {

    @Override
    public void writeFile(File file, String s) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] contentInBytes = s.getBytes();
        fileOutputStream.write(contentInBytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
