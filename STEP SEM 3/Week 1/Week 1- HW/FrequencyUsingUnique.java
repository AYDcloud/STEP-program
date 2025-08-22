import java.util.Scanner;

public class FrequencyUsingUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[][] result = findFrequency(text);
        System.out.println("Character Frequencies:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " -> " + result[i][1]);
        }
        sc.close();
    }

    public static char[] uniqueCharacters(String str) {
        int len = getLength(str);
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

    public static String[][] findFrequency(String str) {
        int[] freq = new int[256];
        int len = getLength(str);
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            freq[c]++;
        }
        char[] unique = uniqueCharacters(str);
        String[][] result = new String[unique.length][2];
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
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
