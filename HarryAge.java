import java.util.Scanner;

public class HarryAge {
    public static void main(String[] args) {
        int birthYear = 2000;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the current year: ");
        int currentYear = scanner.nextInt();
        int age = currentYear - birthYear;
        System.out.println("Harry's age is: " + age);
    }
}