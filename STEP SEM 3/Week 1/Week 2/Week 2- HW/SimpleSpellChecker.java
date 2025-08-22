import java.util.Scanner;

public class SimpleSpellChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dictionary = {"java", "programming", "language", "code", "student", "homework", "spell", "checker"};

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = splitSentence(sentence);
        System.out.println("\nSpell Check Report:");
        System.out.println("Word\t\tSuggestion\tDistance\tStatus");

        for (String word : words) {
            if (word.length() == 0) continue;
            String suggestion = findClosest(word.toLowerCase(), dictionary);
            int distance = stringDistance(word.toLowerCase(), suggestion.toLowerCase());
            if (distance == 0) {
                System.out.println(word + "\t\t" + "-" + "\t\t" + distance + "\t\tCorrect");
            } else if (distance <= 2) {
                System.out.println(word + "\t\t" + suggestion + "\t\t" + distance + "\t\tMisspelled");
            } else {
                System.out.println(word + "\t\t" + "No suggestion" + "\t" + distance + "\t\tMisspelled");
            }
        }
        sc.close();
    }

    public static String[] splitSentence(String sentence) {
        int len = getLength(sentence);
        String[] words = new String[len];
        int start = 0, index = 0;
        for (int i = 0; i <= len; i++) {
            if (i == len || sentence.charAt(i) == ' ' || sentence.charAt(i) == ',' || sentence.charAt(i) == '.') {
                if (start != i) {
                    words[index++] = sentence.substring(start, i);
                }
                start = i + 1;
            }
        }
        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = words[i];
        }
        return result;
    }

    public static int stringDistance(String w1, String w2) {
        int len1 = getLength(w1);
        int len2 = getLength(w2);
        int distance = 0;
        if (len1 == len2) {
            for (int i = 0; i < len1; i++) {
                if (w1.charAt(i) != w2.charAt(i)) {
                    distance++;
                }
            }
        } else {
            distance = Math.abs(len1 - len2);
            int minLen = Math.min(len1, len2);
            for (int i = 0; i < minLen; i++) {
                if (w1.charAt(i) != w2.charAt(i)) {
                    distance++;
                }
            }
        }
        return distance;
    }

    public static String findClosest(String word, String[] dictionary) {
        int minDistance = Integer.MAX_VALUE;
        String suggestion = word;
        for (String dictWord : dictionary) {
            int dist = stringDistance(word, dictWord);
            if (dist < minDistance) {
                minDistance = dist;
                suggestion = dictWord;
            }
        }
        return suggestion;
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
