import java.util.Scanner;
import java.util.Random;

public class PasswordAnalyzerGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of passwords to analyze: ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] passwords = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter password " + (i + 1) + ": ");
            passwords[i] = sc.nextLine();
        }

        System.out.println("\nPassword Analysis Report:");
        System.out.println("Password\tLen\tUpper\tLower\tDigits\tSpecial\tScore\tStrength");
        for (String pwd : passwords) {
            int[] counts = analyzePassword(pwd);
            int score = calculateScore(pwd, counts);
            String strength = getStrength(score);
            System.out.println(pwd + "\t" + counts[0] + "\t" + counts[1] + "\t" + counts[2] + "\t" + counts[3] + "\t" + counts[4] + "\t" + score + "\t" + strength);
        }

        System.out.print("\nEnter desired length for generated strong password: ");
        int genLength = sc.nextInt();
        String strongPwd = generatePassword(genLength);
        System.out.println("Generated Strong Password: " + strongPwd);

        sc.close();
    }

    public static int[] analyzePassword(String pwd) {
        int len = getLength(pwd);
        int upper = 0, lower = 0, digits = 0, special = 0;

        for (int i = 0; i < len; i++) {
            char c = pwd.charAt(i);
            if (c >= 65 && c <= 90) upper++;
            else if (c >= 97 && c <= 122) lower++;
            else if (c >= 48 && c <= 57) digits++;
            else if (c >= 33 && c <= 126) special++;
        }
        return new int[]{len, upper, lower, digits, special};
    }

    public static int calculateScore(String pwd, int[] counts) {
        int score = 0;
        int len = counts[0];

        if (len > 8) {
            score += (len - 8) * 2;
        }

        if (counts[1] > 0) score += 10;
        if (counts[2] > 0) score += 10;
        if (counts[3] > 0) score += 10;
        if (counts[4] > 0) score += 10;

        String lowerPwd = pwd.toLowerCase();
        if (lowerPwd.contains("123") || lowerPwd.contains("abc") || lowerPwd.contains("qwerty")) {
            score -= 10;
        }

        return Math.max(score, 0);
    }

    public static String getStrength(int score) {
        if (score <= 20) return "Weak";
        else if (score <= 50) return "Medium";
        else return "Strong";
    }

    public static String generatePassword(int length) {
        if (length < 4) length = 8;

        Random rand = new Random();
        StringBuilder sb = new StringBuilder();

        sb.append((char) (65 + rand.nextInt(26))); 
        sb.append((char) (97 + rand.nextInt(26))); 
        sb.append((char) (48 + rand.nextInt(10)));  
        sb.append((char) (33 + rand.nextInt(15)));

        String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        for (int i = 4; i < length; i++) {
            sb.append(allChars.charAt(rand.nextInt(allChars.length())));
        }

        char[] pwdChars = sb.toString().toCharArray();
        for (int i = 0; i < pwdChars.length; i++) {
            int j = rand.nextInt(pwdChars.length);
            char temp = pwdChars[i];
            pwdChars[i] = pwdChars[j];
            pwdChars[j] = temp;
        }

        return new String(pwdChars);
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
