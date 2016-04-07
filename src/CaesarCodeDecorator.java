import java.io.File;
import java.io.IOException;

public class CaesarCodeDecorator implements MyFileWorker {
    private final int LETTERS_IN_ALPHABET = 26;
    private final int FIRST_UP_CASE_LETTER_IN_ASCII = 65;
    private final int LAST_UP_CASE_LETTER_IN_ASCII = 90;
    private final int FIRST_LOW_CASE_LETTER_IN_ASCII = 97;
    private final int LAST_LOW_CASE_LETTER_IN_ASCII = 122;
    private final int CAESAR_CODE_OFFSET = 1;
    private final int MAGIC_NUMBER_FOR_UP_CASE = 13;
    private final int MAGIC_NUMBER_FOR_LOW_CASE = 7;

    private MyFileWorkerImpl example;

    public CaesarCodeDecorator(MyFileWorkerImpl example) {
        this.example = example;
    }

    @Override
    public String getBodyFromFile(File file) throws IOException {
        char[] chars = example.getBodyFromFile(file).toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = lowCaseEnglishLettersCoder(chars[i], CAESAR_CODE_OFFSET);
            chars[i] = upCaseEnglishLettersCoder(chars[i], CAESAR_CODE_OFFSET);
            result.append(chars[i]);
        }
        return String.valueOf(result);
    }

    @Override
    public void writeFile(File file, String str) throws IOException {
        char[] chars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            result.append((char)(chars[i] - CAESAR_CODE_OFFSET));
        }
        example.writeFile(file, String.valueOf(result));
    }

    private char lowCaseEnglishLettersCoder(char c, int offset) {
        char result = c;
        if (c >= FIRST_LOW_CASE_LETTER_IN_ASCII && c <= LAST_LOW_CASE_LETTER_IN_ASCII)
            result = (char)((c + MAGIC_NUMBER_FOR_LOW_CASE + offset) % LETTERS_IN_ALPHABET + FIRST_LOW_CASE_LETTER_IN_ASCII);
        return result;
    }

    private char upCaseEnglishLettersCoder(char c, int offset) {
        char result = c;
        if (c >= FIRST_UP_CASE_LETTER_IN_ASCII && c <= LAST_UP_CASE_LETTER_IN_ASCII)
            result = (char)((c + MAGIC_NUMBER_FOR_UP_CASE + offset) % LETTERS_IN_ALPHABET + FIRST_UP_CASE_LETTER_IN_ASCII);
        return result;
    }


}
