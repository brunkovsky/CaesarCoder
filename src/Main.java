import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        MyFileWorker fileWorker = new CaesarCodeDecorator(new MyFileWorkerImpl());
        String str = fileWorker.getBodyFromFile(new File(path));
        fileWorker.writeFile(new File(path + ".enc"), str);
    }
}
