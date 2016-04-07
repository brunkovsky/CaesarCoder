import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileWorkerImpl implements MyFileWorker {

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

    @Override
    public void writeFile(File file, String s) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] contentInBytes = s.getBytes();
        fileOutputStream.write(contentInBytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
