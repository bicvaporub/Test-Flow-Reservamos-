package utils;

import java.util.Random;

public class RandomUtils {
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int NUMBER_LIMIT = 100;
    private static final String UPPERCASE_CYRILLIC_LETTERS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private static final String LOWERCASE_LETTERS = UPPERCASE_LETTERS.toLowerCase();
    private static final Random RANDOM = new Random();

    public static String generateRandomPassword(String email, int passwordLength) {

        StringBuilder password = new StringBuilder();
        password.append(getRandomChar(UPPERCASE_LETTERS));
        password.append(getRandomNumber(NUMBER_LIMIT));
        password.append(getRandomChar(email));
        password.append(getRandomChar(UPPERCASE_CYRILLIC_LETTERS));
        for (int i = password.length(); i < passwordLength; i++) {
            password.append(getRandomChar(LOWERCASE_LETTERS));
        }
        return password.toString();
    }

    public static String generateRandomString(int length) {
        StringBuilder randomString = new StringBuilder();
        String characters = UPPERCASE_LETTERS + LOWERCASE_LETTERS;

        for (int i = 0; i < length; i++) {
            randomString.append(getRandomChar(characters));
        }

        return randomString.toString();
    }

    public static char getRandomChar(String source) {
        return source.charAt(getRandomNumber(source.length()));
    }

    public static int getRandomNumber(int bound) {
        return RANDOM.nextInt(bound);
    }
}
