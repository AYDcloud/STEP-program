import java.util.Scanner;

public class CheckIfDivisibleByFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number");
		int number = scanner.nextInt ();
        if (number % 5 == 0) {
            System.out.print("Is the number " + number + " divisible by 5? Yes");
            } else {
                   System.out.print("Is the number " + number + " divisible by 5? No");
            }
    }
}