import java.util.Scanner;

public class Calculator {
    public static boolean validateExpression(String expr) {
        int balance = 0;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (!(c >= 48 && c <= 57) && !(c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == ' ')) {
                return false;
            }
            if (c == '(') balance++;
            else if (c == ')') balance--;
            if (balance < 0) return false;
        }
        return balance == 0;
    }

    public static int evaluateExpression(String expr) {
        while (expr.contains("(")) {
            int close = expr.indexOf(")");
            int open = expr.lastIndexOf("(", close);
            int val = evaluateExpression(expr.substring(open + 1, close));
            expr = expr.substring(0, open) + val + expr.substring(close + 1);
        }
        return evaluateSimple(expr);
    }

    public static int evaluateSimple(String expr) {
        StringBuilder sb = new StringBuilder(expr.replaceAll(" ", ""));
        for (int i = 0; i < sb.length(); ) {
            if (sb.charAt(i) == '*' || sb.charAt(i) == '/') {
                int leftStart = i - 1;
                while (leftStart >= 0 && Character.isDigit(sb.charAt(leftStart))) leftStart--;
                int left = Integer.parseInt(sb.substring(leftStart + 1, i));
                int rightEnd = i + 1;
                while (rightEnd < sb.length() && Character.isDigit(sb.charAt(rightEnd))) rightEnd++;
                int right = Integer.parseInt(sb.substring(i + 1, rightEnd));
                int val = sb.charAt(i) == '*' ? left * right : left / right;
                sb.replace(leftStart + 1, rightEnd, Integer.toString(val));
                i = leftStart + 1;
            } else i++;
        }
        for (int i = 0; i < sb.length(); ) {
            if (sb.charAt(i) == '+' || sb.charAt(i) == '-') {
                int leftStart = i - 1;
                while (leftStart >= 0 && (Character.isDigit(sb.charAt(leftStart)) || sb.charAt(leftStart) == '-')) leftStart--;
                int left = Integer.parseInt(sb.substring(leftStart + 1, i));
                int rightEnd = i + 1;
                while (rightEnd < sb.length() && (Character.isDigit(sb.charAt(rightEnd)) || sb.charAt(rightEnd) == '-')) rightEnd++;
                int right = Integer.parseInt(sb.substring(i + 1, rightEnd));
                int val = sb.charAt(i) == '+' ? left + right : left - right;
                sb.replace(leftStart + 1, rightEnd, Integer.toString(val));
                i = leftStart + 1;
            } else i++;
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter expressions (type 'exit' to quit):");
        while (true) {
            String expr = sc.nextLine();
            if (expr.equalsIgnoreCase("exit")) break;
            if (!validateExpression(expr)) {
                System.out.println("Invalid expression");
                continue;
            }
            int result = evaluateExpression(expr);
            System.out.println("Result: " + result);
        }
        sc.close();
    }
}
