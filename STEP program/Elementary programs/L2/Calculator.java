import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number1: ");
        double number1 = scanner.nextDouble();
        System.out.print("Enter number2: ");
        double number2 = scanner.nextDouble();

        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number1 / number2;

        System.out.println("The addition, subtraction, multiplication, and division values of " + number1 + " and " + number2 + " are " + addition + ", " + subtraction + ", " + multiplication + ", and " + division + ".");
    }
}
