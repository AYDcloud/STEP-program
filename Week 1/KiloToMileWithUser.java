import java.util.Scanner;

public class KiloToMileWithUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double km = scanner.nextDouble();
        double miles = km / 1.6;
        System.out.println("Distance in miles: " + miles);
    }
}
