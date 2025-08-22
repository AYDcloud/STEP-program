import java.util.Scanner;

public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        char result = findFirstNonRepeating(text);
        if (result != 0) {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found");
        }
        sc.close();
    }

    public static char findFirstNonRepeating(String str) {
        int[] freq = new int[256];
        int len = getLength(str);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            freq[c]++;
        }
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (freq[c] == 1) {
                return c;
            }
        }
        return 0;
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
}
