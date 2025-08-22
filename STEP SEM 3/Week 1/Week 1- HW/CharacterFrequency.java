import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        int[][] result = findFrequency(text);
        System.out.println("Character Frequencies:");
        for (int i = 0; i < result.length; i++) {
            System.out.println((char) result[i][0] + " -> " + result[i][1]);
        }
        sc.close();
    }

    public static int[][] findFrequency(String str) {
        int[] freq = new int[256];
        int len = getLength(str);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            freq[c]++;
        }
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }
        int[][] result = new int[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (freq[c] != 0) {
                result[index][0] = c;
                result[index][1] = freq[c];
                freq[c] = 0;
                index++;
            }
        }
        return result;
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
