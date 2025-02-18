import java.util.Scanner;

public class KiloToMiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double kilometers = scanner.nextDouble();
        double miles = kilometers / 1.6;
        System.out.println("Distance in miles: " + miles);
    }
}
