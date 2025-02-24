import java.util.Scanner;

class IntegerOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        System.out.print("Enter c: ");
        int c = scanner.nextInt();

        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;

        System.out.println("The results of integer operations are " + result1 + ", " + result2 + ", and " + result3 + ".");
    }
}
