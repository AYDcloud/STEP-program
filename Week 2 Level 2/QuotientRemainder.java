import java.util.Scanner;

class QuotientRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number1: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter number2: ");
        int number2 = scanner.nextInt();

        int quotient = number1 / number2;
        int remainder = number1 % number2;

        System.out.println("The quotient is " + quotient + " and remainder is " + remainder + " of two numbers " + number1 + " and " + number2 + ".");
    }
}
