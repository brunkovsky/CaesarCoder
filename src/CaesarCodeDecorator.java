import java.io.File;
import java.io.IOException;

public class CaesarCodeDecorator implements MyFileReader {
    private MyFileReaderImpl example;
    private int i;

    public CaesarCodeDecorator(MyFileReaderImpl example, int i) {
        this.example = example;
        this.i = i;
    }

    @Override
    public String getBodyFromFile(File file) throws IOException {
        return CaesarCoder.makeEncrypt(example.getBodyFromFile(file), i);
    }
}
