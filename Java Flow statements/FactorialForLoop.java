import java.util.Scanner;

class FactorialForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int factorial = 1;

            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }

            System.out.println("The factorial of " + n + " is: " + factorial);
        }

        scanner.close();
    }
}
