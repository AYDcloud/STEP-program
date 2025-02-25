import java.util.Scanner;

class FibonacciSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        int a = 0, b = 1, sum = 0;

        while (n-- > 0) {
            sum += a;
            int temp = a + b;
            a = b;
            b = temp;
        }

        System.out.println("Sum: " + sum);
    }
}
