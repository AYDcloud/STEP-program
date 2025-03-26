import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = new int[10];
        int[] frequency = new int[10];
        int index = 0;

        // Extract digits and store in the digits array
        while (number != 0) {
            digits[index++] = number % 10;
            number /= 10;
        }

        // Count frequency of each digit
        for (int i = 0; i < index; i++) {
            frequency[digits[i]]++;
        }

        // Display frequency of each digit
        System.out.println("Digit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println(i + " -> " + frequency[i]);
            }
        }

        sc.close();
    }
}
