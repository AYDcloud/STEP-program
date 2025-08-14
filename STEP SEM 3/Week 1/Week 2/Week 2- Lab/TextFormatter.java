import java.util.Scanner;

public class TextFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to format:");
        String text = scanner.nextLine();
        System.out.print("Enter desired line width: ");
        int width = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[] words = extractWords(text);

        long startSB = System.nanoTime();
        String justifiedSB = justifyText(words, width);
        long endSB = System.nanoTime();

        long startConcat = System.nanoTime();
        String justifiedConcat = justifyTextConcat(words, width);
        long endConcat = System.nanoTime();

        String centered = centerAlignText(words, width);

        System.out.println("\n=== Original Text ===");
        System.out.println(text);

        System.out.println("\n=== Left-Justified (StringBuilder) ===");
        displayWithLineInfo(justifiedSB);

        System.out.println("\n=== Center-Aligned ===");
        displayWithLineInfo(centered);

        System.out.println("\n=== Performance Analysis ===");
        System.out.println("StringBuilder time: " + (endSB - startSB) + " ns");
        System.out.println("String Concatenation time: " + (endConcat - startConcat) + " ns");

        scanner.close();
    }

    public static String[] extractWords(String text) {
        StringBuilder word = new StringBuilder();
        String[] temp = new String[text.length()];
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    temp[count++] = word.toString();
                    word.setLength(0);
                }
            }
        }
        if (word.length() > 0) {
            temp[count++] = word.toString();
        }

        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            words[i] = temp[i];
        }
        return words;
    }

    public static String justifyText(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int start = i;

            while (i + 1 < words.length && lineLen + 1 + words[i + 1].length() <= width) {
                lineLen += 1 + words[i + 1].length();
                i++;
            }

            int gaps = i - start;
            int extraSpaces = width - lineLen;
            if (gaps > 0 && i != words.length - 1) {
                int spacePerGap = extraSpaces / gaps;
                int remainder = extraSpaces % gaps;

                for (int j = start; j <= i; j++) {
                    result.append(words[j]);
                    if (j < i) {
                        result.append(" ");
                        for (int k = 0; k < spacePerGap; k++) result.append(" ");
                        if (remainder > 0) {
                            result.append(" ");
                            remainder--;
                        }
                    }
                }
            } else {
                for (int j = start; j <= i; j++) {
                    result.append(words[j]);
                    if (j < i) result.append(" ");
                }
            }
            result.append("\n");
            i++;
        }
        return result.toString();
    }

    public static String justifyTextConcat(String[] words, int width) {
        String result = "";
        int i = 0;

        while (i < words.length) {
            int lineLen = words[i].length();
            int start = i;

            while (i + 1 < words.length && lineLen + 1 + words[i + 1].length() <= width) {
                lineLen += 1 + words[i + 1].length();
                i++;
            }

            int gaps = i - start;
            int extraSpaces = width - lineLen;
            if (gaps > 0 && i != words.length - 1) {
                int spacePerGap = extraSpaces / gaps;
                int remainder = extraSpaces % gaps;

                for (int j = start; j <= i; j++) {
                    result += words[j];
                    if (j < i) {
                        result += " ";
                        for (int k = 0; k < spacePerGap; k++) result += " ";
                        if (remainder > 0) {
                            result += " ";
                            remainder--;
                        }
                    }
                }
            } else {
                for (int j = start; j <= i; j++) {
                    result += words[j];
                    if (j < i) result += " ";
                }
            }
            result += "\n";
            i++;
        }
        return result;
    }

    public static String centerAlignText(String[] words, int width) {
        StringBuilder result = new StringBuilder();
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (line.length() + (line.length() == 0 ? 0 : 1) + words[i].length() <= width) {
                if (line.length() > 0) line.append(" ");
                line.append(words[i]);
            } else {
                int padding = (width - line.length()) / 2;
                for (int p = 0; p < padding; p++) result.append(" ");
                result.append(line).append("\n");
                line.setLength(0);
                line.append(words[i]);
            }
        }
        int padding = (width - line.length()) / 2;
        for (int p = 0; p < padding; p++) result.append(" ");
        result.append(line).append("\n");

        return result.toString();
    }

    public static void displayWithLineInfo(String text) {
        String[] lines = text.split("\n");
        for (int i = 0; i < lines.length; i++) {
            System.out.println((i + 1) + ": " + lines[i] + " (" + lines[i].length() + " chars)");
        }
    }
}
