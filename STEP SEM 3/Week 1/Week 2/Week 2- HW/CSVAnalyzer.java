import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class CSVAnalyzer {
    public static String[][] parseCSV(String input) {
        int rows = 0;
        for (int i = 0; i < input.length(); i++) if (input.charAt(i) == '\n') rows++;
        rows++;
        int cols = 0, temp = 0;
        for (int i = 0; i < input.length() && input.charAt(i) != '\n'; i++) if (input.charAt(i) == ',') temp++;
        cols = temp + 1;
        String[][] data = new String[rows][cols];
        int r = 0, c = 0, start = 0;
        boolean inQuotes = false;
        for (int i = 0; i <= input.length(); i++) {
            if (i == input.length() || (input.charAt(i) == ',' && !inQuotes) || (input.charAt(i) == '\n' && !inQuotes)) {
                data[r][c] = input.substring(start, i);
                c++;
                if (i == input.length() || input.charAt(i) == '\n') {
                    r++;
                    c = 0;
                }
                start = i + 1;
            } else if (input.charAt(i) == '"') inQuotes = !inQuotes;
        }
        return data;
    }

    public static String cleanField(String field) {
        field = field.trim();
        if (field.startsWith("\"") && field.endsWith("\"")) field = field.substring(1, field.length() - 1);
        return field.trim();
    }

    public static boolean isNumeric(String s) {
        if (s == null || s.isEmpty()) return false;
        int dots = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '.') dots++;
            else if (ch < '0' || ch > '9') return false;
            if (dots > 1) return false;
        }
        return true;
    }

    public static void analyzeData(String[][] data) {
        int rows = data.length, cols = data[0].length;
        double[] min = new double[cols];
        double[] max = new double[cols];
        double[] sum = new double[cols];
        int[] count = new int[cols];
        HashMap<Integer, HashSet<String>> uniques = new HashMap<>();
        for (int j = 0; j < cols; j++) {
            min[j] = Double.MAX_VALUE;
            max[j] = -Double.MAX_VALUE;
            sum[j] = 0;
            count[j] = 0;
            uniques.put(j, new HashSet<>());
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String val = cleanField(data[i][j]);
                data[i][j] = val;
                if (isNumeric(val)) {
                    double num = Double.parseDouble(val);
                    if (num < min[j]) min[j] = num;
                    if (num > max[j]) max[j] = num;
                    sum[j] += num;
                    count[j]++;
                } else uniques.get(j).add(val);
            }
        }
        formatTable(data);
        summaryReport(data, min, max, sum, count, uniques);
    }

    public static void formatTable(String[][] data) {
        int rows = data.length, cols = data[0].length;
        int[] width = new int[cols];
        for (int j = 0; j < cols; j++) {
            width[j] = 0;
            for (int i = 0; i < rows; i++) if (data[i][j].length() > width[j]) width[j] = data[i][j].length();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%-" + (width[j] + 2) + "s", data[i][j]));
            }
            sb.append("\n");
        }
        System.out.println("Formatted Table:");
        System.out.println(sb.toString());
    }

    public static void summaryReport(String[][] data, double[] min, double[] max, double[] sum, int[] count, HashMap<Integer, HashSet<String>> uniques) {
        int cols = data[0].length;
        int rows = data.length - 1;
        System.out.println("Summary Report:");
        System.out.println("Total records: " + rows);
        for (int j = 0; j < cols; j++) {
            System.out.println("Column: " + data[0][j]);
            if (count[j] > 0) {
                System.out.println(" Min: " + min[j]);
                System.out.println(" Max: " + max[j]);
                System.out.println(" Avg: " + (sum[j] / count[j]));
            } else {
                System.out.println(" Unique values: " + uniques.get(j).size());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter CSV data (type END on new line to finish):");
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("END")) break;
            sb.append(line).append("\n");
        }
        String[][] data = parseCSV(sb.toString().trim());
        analyzeData(data);
        sc.close();
    }
}
