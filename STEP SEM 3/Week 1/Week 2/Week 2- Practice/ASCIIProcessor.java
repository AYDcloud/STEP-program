import java.util.Scanner;

public class ASCIIProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int ascii = (int) ch;
            System.out.print("Character: '" + ch + "' | ASCII: " + ascii + " | Type: " + classifyCharacter(ch));
            if (Character.isLetter(ch)) {
                char upper = Character.toUpperCase(ch);
                char lower = Character.toLowerCase(ch);
                System.out.print(" | Upper: '" + upper + "' (" + (int) upper + ")");
                System.out.print(" | Lower: '" + lower + "' (" + (int) lower + ")");
                System.out.print(" | Difference: " + Math.abs((int) upper - (int) lower));
            }
            System.out.println();
        }

        System.out.println("\nASCII Table (65 to 90):");
        displayASCIITable(65, 90);

        System.out.println("\nCaesar Cipher (shift 3): " + caesarCipher(input, 3));

        int[] asciiArray = stringToASCII(input);
        System.out.print("ASCII Array: ");
        for (int i = 0; i < asciiArray.length; i++) {
            System.out.print(asciiArray[i] + " ");
        }
        System.out.println();
        System.out.println("Back to String: " + asciiToString(asciiArray));

        scanner.close();
    }

    public static String classifyCharacter(char ch) {
        if (ch >= 'A' && ch <= 'Z') return "Uppercase Letter";
        if (ch >= 'a' && ch <= 'z') return "Lowercase Letter";
        if (ch >= '0' && ch <= '9') return "Digit";
        return "Special Character";
    }

    public static char toggleCase(char ch) {
        if (ch >= 'A' && ch <= 'Z') return (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') return (char) (ch - 32);
        return ch;
    }

    public static String caesarCipher(String text, int shift) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isUpperCase(ch)) {
                result += (char) (((ch - 'A' + shift) % 26) + 'A');
            } else if (Character.isLowerCase(ch)) {
                result += (char) (((ch - 'a' + shift) % 26) + 'a');
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static void displayASCIITable(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.println(i + " -> " + (char) i);
        }
    }

    public static int[] stringToASCII(String text) {
        int[] asciiValues = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            asciiValues[i] = (int) text.charAt(i);
        }
        return asciiValues;
    }

    public static String asciiToString(int[] asciiValues) {
        String result = "";
        for (int value : asciiValues) {
            result += (char) value;
        }
        return result;
    }
}
