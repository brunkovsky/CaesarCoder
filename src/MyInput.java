import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MyInput {
    private Set<String> setOfVariants = new HashSet<>();

    public MyInput(String... strings) {
        Collections.addAll(setOfVariants, strings);
    }

    public String getAnswer() {
        outputVariant();
        String result;
        Scanner scanner = new Scanner(System.in);
        do {
            result = scanner.nextLine();
            if (setOfVariants.contains(result)) {
                break;
            }
        } while (true);
        return result;
    }

    private void outputVariant() {
        System.out.print("Please select one of the options: " + setOfVariants + ": ");
    }
}
