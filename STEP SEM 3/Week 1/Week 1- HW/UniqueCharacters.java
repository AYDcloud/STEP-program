import java.util.Scanner;

public class UniqueCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        int len = getLength(text);
        char[] unique = findUnique(text, len);
        System.out.print("Unique characters: ");
        for (char c : unique) {
            System.out.print(c + " ");
        }
        sc.close();
    }

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static char[] findUnique(String str, int len) {
        char[] temp = new char[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[index++] = c;
            }
        }
        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }
        return result;
    }
}
