import java.util.Scanner;

public class SumUntilZeroAndNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double number;

        System.out.print("Enter a number (0 or negative to stop): ");
        number = scanner.nextDouble();

        while (number >= 0) {
            total += number;
            System.out.print("Enter a number (0 or negative to stop): ");
            number = scanner.nextDouble();
        }

        System.out.println("Total sum: " + total);
        scanner.close();
    }
}
