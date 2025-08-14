import java.util.*;

class substringIndexOf {
    static boolean isValid(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        if (at == -1 || at != lastAt) return false;
        int dot = email.indexOf('.', at);
        if (dot == -1) return false;
        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        if (username.isEmpty() || domain.isEmpty()) return false;
        return true;
    }

    static String[] extractParts(String email) {
        int at = email.indexOf('@');
        int dot = email.indexOf('.', at);
        String username = email.substring(0, at);
        String domain = email.substring(at + 1);
        String domainName = domain.substring(0, domain.indexOf('.'));
        String extension = domain.substring(domain.indexOf('.') + 1);
        return new String[]{username, domain, domainName, extension};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> emails = new ArrayList<>();
        System.out.println("Enter emails (type 'done' to finish):");
        while (true) {
            String email = sc.nextLine();
            if (email.equalsIgnoreCase("done")) break;
            emails.add(email);
        }
        Map<String,Integer> domainCount = new HashMap<>();
        int validCount = 0, invalidCount = 0, totalUsernameLength = 0;
        System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s%n", "Email", "Username", "Domain", "Domain Name", "Ext", "Valid?");
        for (String email : emails) {
            boolean valid = isValid(email);
            if (valid) {
                validCount++;
                String[] parts = extractParts(email);
                totalUsernameLength += parts[0].length();
                domainCount.put(parts[1], domainCount.getOrDefault(parts[1], 0) + 1);
                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s%n", email, parts[0], parts[1], parts[2], parts[3], "Yes");
            } else {
                invalidCount++;
                System.out.printf("%-25s %-15s %-20s %-15s %-10s %-10s%n", email, "-", "-", "-", "-", "No");
            }
        }
        String mostCommonDomain = "";
        int maxCount = 0;
        for (Map.Entry<String,Integer> e : domainCount.entrySet()) {
            if (e.getValue() > maxCount) {
                maxCount = e.getValue();
                mostCommonDomain = e.getKey();
            }
        }
        double avgUsernameLength = validCount > 0 ? (double)totalUsernameLength / validCount : 0;
        System.out.println("Valid Emails: " + validCount);
        System.out.println("Invalid Emails: " + invalidCount);
        System.out.println("Most Common Domain: " + mostCommonDomain);
        System.out.println("Average Username Length: " + avgUsernameLength);
        sc.close();
    }
}
