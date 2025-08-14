import java.util.*;

class shiftASCII {
    static String encrypt(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') sb.append((char)('A' + (c - 'A' + shift) % 26));
            else if (c >= 'a' && c <= 'z') sb.append((char)('a' + (c - 'a' + shift) % 26));
            else sb.append(c);
        }
        return sb.toString();
    }

    static String decrypt(String text, int shift) {
        return encrypt(text, (26 - (shift % 26)) % 26);
    }

    static void displayAscii(String label, String text) {
        System.out.print(label + ": ");
        for (int i = 0; i < text.length(); i++) System.out.print((int)text.charAt(i) + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter shift value: ");
        int shift = sc.nextInt();
        displayAscii("Original ASCII", text);
        String encrypted = encrypt(text, shift);
        displayAscii("Encrypted ASCII", encrypted);
        String decrypted = decrypt(encrypted, shift);
        displayAscii("Decrypted ASCII", decrypted);
        System.out.println("Original: " + text);
        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println("Decryption matches original: " + text.equals(decrypted));
        sc.close();
    }
}
