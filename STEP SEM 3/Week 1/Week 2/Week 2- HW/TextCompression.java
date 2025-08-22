import java.util.Scanner;

public class TextCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to compress:");
        String text = sc.nextLine();

        char[] uniqueChars = new char[text.length()];
        int[] freq = new int[text.length()];
        int uniqueCount = countFrequency(text, uniqueChars, freq);

        String[][] mapping = generateCodes(uniqueChars, freq, uniqueCount);
        String compressed = compressText(text, mapping);
        String decompressed = decompressText(compressed, mapping);

        displayAnalysis(text, compressed, decompressed, uniqueChars, freq, uniqueCount, mapping);
        sc.close();
    }

    public static int countFrequency(String text, char[] chars, int[] freq) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < count; j++) {
                if (chars[j] == c) {
                    freq[j]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                chars[count] = c;
                freq[count] = 1;
                count++;
            }
        }
        return count;
    }

    public static String[][] generateCodes(char[] chars, int[] freq, int n) {
        String[][] mapping = new String[n][2];
        for (int i = 0; i < n; i++) {
            mapping[i][0] = String.valueOf(chars[i]);
            mapping[i][1] = generateCode(freq[i], i);
        }
        return mapping;
    }

    public static String generateCode(int frequency, int index) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)('A' + (index % 26)));
        if (frequency > 2) sb.append(index % 10);
        return sb.toString();
    }

    public static String compressText(String text, String[][] mapping) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            for (int j = 0; j < mapping.length; j++) {
                if (mapping[j][0].charAt(0) == c) {
                    sb.append(mapping[j][1]);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static String decompressText(String compressed, String[][] mapping) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < compressed.length()) {
            boolean matched = false;
            for (int j = 0; j < mapping.length; j++) {
                String code = mapping[j][1];
                if (compressed.startsWith(code, i)) {
                    sb.append(mapping[j][0]);
                    i += code.length();
                    matched = true;
                    break;
                }
            }
            if (!matched) i++;
        }
        return sb.toString();
    }

    public static void displayAnalysis(String text, String compressed, String decompressed,
                                       char[] chars, int[] freq, int n, String[][] mapping) {
        System.out.println("Character Frequency:");
        for (int i = 0; i < n; i++) {
            System.out.println(chars[i] + " : " + freq[i]);
        }
        System.out.println("\nCompression Mapping:");
        for (int i = 0; i < mapping.length; i++) {
            System.out.println(mapping[i][0] + " -> " + mapping[i][1]);
        }
        System.out.println("\nOriginal Text: " + text);
        System.out.println("Compressed Text: " + compressed);
        System.out.println("Decompressed Text: " + decompressed);
        double ratio = (double)compressed.length() / text.length() * 100;
        System.out.println("Compression Efficiency: " + ratio + "%");
    }
}
