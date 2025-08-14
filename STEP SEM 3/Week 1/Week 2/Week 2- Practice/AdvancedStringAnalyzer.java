import java.util.Scanner;

public class AdvancedStringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== ADVANCED STRING ANALYZER ===");

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        performAllComparisons(str1, str2);
        System.out.println("Similarity percentage: " + calculateSimilarity(str1, str2) + "%");
        analyzeMemoryUsage(str1, str2);
        String[] sampleInputs = {str1, str2, "Extra", "Data"};
        System.out.println("Optimized processing result: " + optimizedStringProcessing(sampleInputs));
        demonstrateStringIntern();

        scanner.close();
    }

    public static double calculateSimilarity(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) dp[i][0] = i;
        for (int j = 0; j <= len2; j++) dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = (str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                        dp[i - 1][j - 1] + cost);
            }
        }
        int levenshteinDistance = dp[len1][len2];
        int maxLen = Math.max(len1, len2);
        if (maxLen == 0) return 100.0;
        return ((double) (maxLen - levenshteinDistance) / maxLen) * 100.0;
    }

    public static void performAllComparisons(String str1, String str2) {
        System.out.println("Reference equality (==): " + (str1 == str2));
        System.out.println("Content equality (equals): " + str1.equals(str2));
        System.out.println("Case-insensitive equality: " + str1.equalsIgnoreCase(str2));
        System.out.println("Lexicographic comparison: " + str1.compareTo(str2));
        System.out.println("Case-insensitive lexicographic: " + str1.compareToIgnoreCase(str2));
    }

    public static void analyzeMemoryUsage(String... strings) {
        System.out.println("Approximate memory usage (characters × 2 bytes):");
        for (String s : strings) {
            System.out.println("'" + s + "' uses about " + (s.length() * 2) + " bytes");
        }
    }

    public static String optimizedStringProcessing(String[] inputs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputs.length; i++) {
            sb.append(inputs[i]);
            if (i < inputs.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static void demonstrateStringIntern() {
        String a = new String("Hello");
        String b = "Hello";
        String c = a.intern();

        System.out.println("a == b: " + (a == b));
        System.out.println("b == c: " + (b == c));
        System.out.println("a.intern() == b: " + (a.intern() == b));
    }
}
