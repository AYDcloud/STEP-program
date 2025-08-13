import java.util.Scanner;

public class TextProcessor {
    public static String cleanInput(String input) {
        input = input.trim().replaceAll("\\s+", " ");
        StringBuilder cleaned = new StringBuilder();
        boolean capitalizeNext = true;
        for (char c : input.toCharArray()) {
            if (capitalizeNext && Character.isLetter(c)) {
                cleaned.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                cleaned.append(Character.toLowerCase(c));
            }
            if (c == '.' || c == '!' || c == '?') {
                capitalizeNext = true;
            }
        }
        return cleaned.toString();
    }

    public static void analyzeText(String text) {
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        int sentenceCount = text.split("[.!?]").length;
        int charCount = text.replaceAll("\\s", "").length();
        
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        
        String lowerText = text.toLowerCase();
        char mostCommonChar = ' ';
        int maxFreq = 0;
        for (int i = 0; i < lowerText.length(); i++) {
            char c = lowerText.charAt(i);
            int count = 0;
            for (int j = 0; j < lowerText.length(); j++) {
                if (lowerText.charAt(j) == c) {
                    count++;
                }
            }
            if (count > maxFreq) {
                maxFreq = count;
                mostCommonChar = c;
            }
        }
        
        System.out.println("\n    Text Analysis    ");
        System.out.println("Words count: " + wordCount);
        System.out.println("Sentences count: " + sentenceCount);
        System.out.println("Characters count: " + charCount);
        System.out.println("Longest word: " + longestWord);
        System.out.println("Most common character: '" + mostCommonChar + "' appeared " + maxFreq + " times");
    }

    public static String[] getWordsSorted(String text) {
        String[] words = text.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1 - i; j++) {
                if (words[j].compareTo(words[j + 1]) > 0) {
                    String temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
        return words;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== TEXT PROCESSOR ===");
        System.out.println("Enter a paragraph of text:");
        String input = scanner.nextLine();
        
        String cleanedInput = cleanInput(input);
        System.out.println("\nCleaned Text:\n" + cleanedInput);
        
        analyzeText(cleanedInput);
        
        String[] sortedWords = getWordsSorted(cleanedInput);
        System.out.println("\nWords in alphabetical order:");
        for (String word : sortedWords) {
            System.out.println(word);
        }
        
        while (true) {
            System.out.println("\nEnter a word to search for (or type 'exit' to quit):");
            String searchWord = scanner.nextLine().toLowerCase().trim();
            if (searchWord.equals("exit")) {
                break;
            }
            int count = 0;
            for (String word : sortedWords) {
                if (word.equals(searchWord)) {
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("The word '" + searchWord + "' appears " + count + " time(s) in the text.");
            } else {
                System.out.println("The word '" + searchWord + "' does not appear in the text.");
            }
        }
        
        scanner.close();
    }
}