import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final int CAESAR_CODE_KEY_OFFSET = 1;

    public static void main(String[] args) throws IOException {
        MyInput myInput = new MyInput("1", "2");
        String answer = myInput.getAnswer("1 - coding text / 2 - decoding text. ");
        MyFileReader fileEncryptingReader = new CaesarCodeDecorator(new MyFileReaderImpl(), CAESAR_CODE_KEY_OFFSET);
        MyFileReader fileDecodingReader = new CaesarCodeDecorator(new MyFileReaderImpl(), -CAESAR_CODE_KEY_OFFSET);
        Scanner scanner = new Scanner(System.in);
        System.out.print("input path to file: ");
        String path = scanner.nextLine();
        MyFileWriter fileWriter = new MyFileWriterImpl();
        String str;
        switch (answer) {
            case "1" :
                str = fileEncryptingReader.getBodyFromFile(new File(path));
                fileWriter.writeFile(new File(path + ".enc"), str);
                break;
            case "2" :
                str = fileDecodingReader.getBodyFromFile(new File(path));
                fileWriter.writeFile(new File(path + ".dec"), str);
                break;
        }

    }
}
