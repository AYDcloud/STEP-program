import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int originalNum = num, sum = 0;
        while (originalNum > 0) {
            int digit = originalNum % 10;
            sum += digit * digit * digit;
            originalNum /= 10;
        }
        System.out.println(num + (sum == num ? " is an Armstrong Number" : " is not an Armstrong Number"));
    }
}
