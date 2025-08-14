import java.util.*;

class tempCodeRunnerFile {
    static List<Integer> findOccurrences(String text, String findStr) {
        List<Integer> positions = new ArrayList<>();
        int index = text.indexOf(findStr);
        while (index != -1) {
            positions.add(index);
            index = text.indexOf(findStr, index + findStr.length());
        }
        return positions;
    }

    static String manualReplace(String text, String findStr, String replaceStr) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            if (i <= text.length() - findStr.length() && text.substring(i, i + findStr.length()).equals(findStr)) {
                result.append(replaceStr);
                i += findStr.length();
            } else {
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    static boolean compareWithBuiltIn(String manualResult, String text, String findStr, String replaceStr) {
        return manualResult.equals(text.replace(findStr, replaceStr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the main text: ");
        String text = sc.nextLine();
        System.out.print("Enter the substring to find: ");
        String findStr = sc.nextLine();
        System.out.print("Enter the replacement substring: ");
        String replaceStr = sc.nextLine();
        List<Integer> positions = findOccurrences(text, findStr);
        System.out.println("Occurrences at positions: " + positions);
        String manualResult = manualReplace(text, findStr, replaceStr);
        System.out.println("Manual Replace Result: " + manualResult);
        System.out.println("Built-in Replace Result: " + text.replace(findStr, replaceStr));
        System.out.println("Manual result matches built-in replace(): " + compareWithBuiltIn(manualResult, text, findStr, replaceStr));
        sc.close();
    }
}
