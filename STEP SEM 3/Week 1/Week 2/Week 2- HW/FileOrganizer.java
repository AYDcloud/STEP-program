import java.util.Scanner;

public class FileOrganizer {
    public static String[][] extractFileComponents(String[] files) {
        String[][] details = new String[files.length][2];
        for (int i = 0; i < files.length; i++) {
            int dotIndex = files[i].lastIndexOf('.');
            if (dotIndex != -1 && dotIndex < files[i].length() - 1) {
                details[i][0] = files[i].substring(0, dotIndex);
                details[i][1] = files[i].substring(dotIndex + 1);
            } else {
                details[i][0] = files[i];
                details[i][1] = "";
            }
        }
        return details;
    }

    public static String[] categorizeFiles(String[][] details) {
        String[] categories = new String[details.length];
        for (int i = 0; i < details.length; i++) {
            String ext = details[i][1].toLowerCase();
            if (ext.equals("txt") || ext.equals("doc")) categories[i] = "Document";
            else if (ext.equals("jpg") || ext.equals("png")) categories[i] = "Image";
            else if (ext.equals("mp3") || ext.equals("wav")) categories[i] = "Audio";
            else if (ext.equals("mp4") || ext.equals("avi")) categories[i] = "Video";
            else if (ext.equals("pdf")) categories[i] = "PDF";
            else categories[i] = "Unknown";
        }
        return categories;
    }

    public static String[] generateNewNames(String[][] details, String[] categories) {
        String[] newNames = new String[details.length];
        for (int i = 0; i < details.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(categories[i]);
            sb.append("_");
            sb.append(details[i][0]);
            sb.append(".");
            sb.append(details[i][1]);
            newNames[i] = sb.toString();
        }
        return newNames;
    }

    public static void displayReport(String[] files, String[][] details, String[] categories, String[] newNames) {
        System.out.println("File Organization Report:");
        System.out.println("--------------------------------------------");
        System.out.printf("%-20s %-12s %-20s\n", "Original Name", "Category", "New Suggested Name");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < files.length; i++) {
            System.out.printf("%-20s %-12s %-20s\n", files[i], categories[i], newNames[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of files:");
        int n = sc.nextInt();
        sc.nextLine();
        String[] files = new String[n];
        for (int i = 0; i < n; i++) {
            files[i] = sc.nextLine();
        }

        String[][] details = extractFileComponents(files);
        String[] categories = categorizeFiles(details);
        String[] newNames = generateNewNames(details, categories);

        displayReport(files, details, categories, newNames);
    }
}
