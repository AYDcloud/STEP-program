 import java.util.Scanner;

class PoundToKilogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight in pounds");
        double pounds = scanner.nextDouble();
        double kiloResult = pounds/(2.2);
        System.out.print("The weight of the person in pounds is " + pounds + " and in kg is " + kiloResult);
    }
}