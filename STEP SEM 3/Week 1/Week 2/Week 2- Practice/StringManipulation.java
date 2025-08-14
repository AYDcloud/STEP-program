import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence with mixed formatting:");
        String input = scanner.nextLine();

        String trimmed = input.trim();
        String replacedSpaces = trimmed.replace(" ", "_");
        String noDigits = replacedSpaces.replaceAll("\\d", "");
        String[] wordsArray = trimmed.split("\\s+");
        String joined = "";
        for (int i = 0; i < wordsArray.length; i++) {
            joined += wordsArray[i];
            if (i < wordsArray.length - 1) {
                joined += " | ";
            }
        }

        System.out.println("Trimmed: " + trimmed);
        System.out.println("Spaces replaced with underscores: " + replacedSpaces);
        System.out.println("Digits removed: " + noDigits);
        System.out.print("Words array: [");
        for (int i = 0; i < wordsArray.length; i++) {
            System.out.print(wordsArray[i]);
            if (i < wordsArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println("Joined with ' | ': " + joined);

        System.out.println("Without punctuation: " + removePunctuation(trimmed));
        System.out.println("Capitalized words: " + capitalizeWords(trimmed));
        System.out.println("Reversed word order: " + reverseWordOrder(trimmed));
        countWordFrequency(trimmed);

        scanner.close();
    }

    public static String removePunctuation(String text) {
        return text.replaceAll("\\p{Punct}", "");
    }

    public static String capitalizeWords(String text) {
        String[] words = text.toLowerCase().split("\\s+");
        String result = "";
        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty()) {
                result += Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
                if (i < words.length - 1) {
                    result += " ";
                }
            }
        }
        return result;
    }

    public static String reverseWordOrder(String text) {
        String[] words = text.trim().split("\\s+");
        String result = "";
        for (int i = words.length - 1; i >= 0; i--) {
            result += words[i];
            if (i > 0) {
                result += " ";
            }
        }
        return result;
    }

    public static void countWordFrequency(String text) {
        String[] words = text.toLowerCase().replaceAll("\\p{Punct}", "").split("\\s+");
        boolean[] counted = new boolean[words.length];
        System.out.println("Word frequencies:");
        for (int i = 0; i < words.length; i++) {
            if (!counted[i]) {
                int count = 1;
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                        counted[j] = true;
                    }
                }
                System.out.println(words[i] + ": " + count);
            }
        }
    }
}
