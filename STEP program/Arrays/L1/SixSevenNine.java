import java.util.Scanner;

public class SixSevenNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

       
        int[] table = new int[9];
        for (int i = 5; i < table.length; i++) {
            table[i] = number * (i + 1);
        }
        for (int i = 5; i < table.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + table[i]);
        }
    }
}
