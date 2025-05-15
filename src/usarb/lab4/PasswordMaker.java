package usarb.lab4;

import java.util.Random;

public class PasswordMaker {
    private static final Random random = new Random();
    private static final int MAGIC_NUMBER = 8;
    private static final String MAGIC_STRING = generateRandomString(20);

    private static final PasswordMaker instance = new PasswordMaker("default"); // Eager Initialization
    private static int instanceAccessCount = 0;

    private String name;

    private PasswordMaker(String name) {
        this.name = name;
    }

    public static PasswordMaker getInstance(String name) {
        instanceAccessCount++;
        instance.name = name;
        return instance;
    }

    public static int getInstanceAccessCount() {
        return instanceAccessCount;
    }

    public String getPassword() {
        String alphabet = getRandomSubstring(MAGIC_STRING, 10);
        String randomPart = generateRandomStringFromAlphabet(MAGIC_NUMBER, alphabet);
        int nameLength = name.length();
        int randomNumber = random.nextInt(101); // [0, 100]
        return randomPart + nameLength + randomNumber;
    }

    private static String getRandomSubstring(String str, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(str.length());
            sb.append(str.charAt(index));
        }
        return sb.toString();
    }

    private static String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    private static String generateRandomStringFromAlphabet(int length, String alphabet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }
}

// Pot apărea probleme de concurență (race condition), dacă mai multe thread-uri accesează getInstance() simultan în același timp, fără sincronizare. Soluții: sincronizare (synchronized), volatile, double-checked locking, enum-based Singleton etc.