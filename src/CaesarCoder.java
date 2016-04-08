public class CaesarCoder {
    private static final int LETTERS_IN_ALPHABET = 26;
    private static final int FIRST_UP_CASE_LETTER_IN_ASCII = 65;
    private static final int LAST_UP_CASE_LETTER_IN_ASCII = 90;
    private static final int FIRST_LOW_CASE_LETTER_IN_ASCII = 97;
    private static final int LAST_LOW_CASE_LETTER_IN_ASCII = 122;
    private static final int MAGIC_NUMBER_FOR_UP_CASE = 13;
    private static final int MAGIC_NUMBER_FOR_LOW_CASE = 7;

    public static String makeEncrypt(String inputString, int key) {
        char[] chars = inputString.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = lowCaseEnglishLettersCoder(chars[i], key);
            chars[i] = upCaseEnglishLettersCoder(chars[i], key);
            result.append(chars[i]);
        }
        return String.valueOf(result);
    }

    private static char lowCaseEnglishLettersCoder(char c, int offset) {
        char result = c;
        if (c >= FIRST_LOW_CASE_LETTER_IN_ASCII && c <= LAST_LOW_CASE_LETTER_IN_ASCII)
            result = (char)((c + MAGIC_NUMBER_FOR_LOW_CASE + offset) % LETTERS_IN_ALPHABET + FIRST_LOW_CASE_LETTER_IN_ASCII);
        return result;
    }

    private static char upCaseEnglishLettersCoder(char c, int offset) {
        char result = c;
        if (c >= FIRST_UP_CASE_LETTER_IN_ASCII && c <= LAST_UP_CASE_LETTER_IN_ASCII)
            result = (char)((c + MAGIC_NUMBER_FOR_UP_CASE + offset) % LETTERS_IN_ALPHABET + FIRST_UP_CASE_LETTER_IN_ASCII);
        return result;
    }
}
