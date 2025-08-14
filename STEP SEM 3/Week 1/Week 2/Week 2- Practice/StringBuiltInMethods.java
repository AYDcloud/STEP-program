public class StringBuiltInMethods {
    public static void main(String[] args) {
        String sampleText = " Java Programming is Fun and Challenging! ";
        System.out.println("Original length (with spaces): " + sampleText.length());
        String trimmedText = sampleText.trim();
        System.out.println("Trimmed length: " + trimmedText.length());
        System.out.println("Character at index 5: " + sampleText.charAt(5));
        System.out.println("Substring 'Programming': " + sampleText.substring(6, 17));
        System.out.println("Index of 'Fun': " + sampleText.indexOf("Fun"));
        System.out.println("Contains 'Java': " + sampleText.contains("Java"));
        System.out.println("Starts with 'Java' after trimming: " + trimmedText.startsWith("Java"));
        System.out.println("Ends with '!': " + sampleText.endsWith("!"));
        System.out.println("Uppercase: " + sampleText.toUpperCase());
        System.out.println("Lowercase: " + sampleText.toLowerCase());
        System.out.println("Vowel count: " + countVowels(sampleText));
        findAllOccurrences(sampleText, 'a');
    }

    public static int countVowels(String text) {
        int count = 0;
        String vowels = "AEIOUaeiou";
        for (int i = 0; i < text.length(); i++) {
            if (vowels.indexOf(text.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target) {
        System.out.print("Occurrences of '" + target + "' at positions: ");
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == target) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
