import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Coder - 1 / Decoder - 2");
        MyInput myOneTwoInput = new MyInput("1", "2");
        String answer = myOneTwoInput.getAnswer();
        System.out.println(answer);
        MyFileWorker fileWorker = new CaesarCodeDecorator(new MyFileWorkerImpl());
        String str = fileWorker.getBodyFromFile(new File("/Volumes/Users/Stas/example0.cpp"));
        System.out.println(str);
        fileWorker.writeFile(new File("/Volumes/Users/Stas/example1.cpp"), str);
    }
}
