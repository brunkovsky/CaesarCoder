import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyInput {
    private Set<String> setOfVariants = new HashSet<>();

    public MyInput(String... strings) {
        Collections.addAll(setOfVariants, strings);
    }

    public String getAnswer(String message) {
        System.out.print(message + setOfVariants + ": ");
        String result;
        Scanner scanner = new Scanner(System.in);
        do {
            result = scanner.nextLine();
        } while (!setOfVariants.contains(result));
        return result;
    }

    public String getAnswer() {
        return getAnswer("");
    }
}
