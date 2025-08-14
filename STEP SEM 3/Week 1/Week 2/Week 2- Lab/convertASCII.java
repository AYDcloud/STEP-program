import java.util.*;

class convertASCII {
    static char toUpper(char c) {
        if (c >= 97 && c <= 122) return (char)(c - 32);
        return c;
    }

    static char toLower(char c) {
        if (c >= 65 && c <= 90) return (char)(c + 32);
        return c;
    }

    static String convertToUpper(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) sb.append(toUpper(text.charAt(i)));
        return sb.toString();
    }

    static String convertToLower(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) sb.append(toLower(text.charAt(i)));
        return sb.toString();
    }

    static String convertToTitle(String text) {
        StringBuilder sb = new StringBuilder();
        boolean newWord = true;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isWhitespace(c)) {
                sb.append(c);
                newWord = true;
            } else {
                if (newWord) {
                    sb.append(toUpper(c));
                    newWord = false;
                } else sb.append(toLower(c));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String upperManual = convertToUpper(text);
        String lowerManual = convertToLower(text);
        String titleManual = convertToTitle(text);
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Case", "Manual", "Built-in", "Matches?");
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Uppercase", upperManual, text.toUpperCase(), upperManual.equals(text.toUpperCase()));
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Lowercase", lowerManual, text.toLowerCase(), lowerManual.equals(text.toLowerCase()));
        System.out.printf("%-20s %-20s %-20s %-20s%n", "Titlecase", titleManual, "", "");
        sc.close();
    }
}
