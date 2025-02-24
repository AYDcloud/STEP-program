 import java.util.Scanner;

class RewriteSampleWithUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter fromCity: ");
        String fromCity = scanner.next();
        System.out.print("Enter viaCity: ");
        String viaCity = scanner.next();
        System.out.print("Enter ioCity: ");
        String ioCity = scanner.next();
        System.out.print("Enter distance from IO/Aa in miles: ");
        double distance1 = scanner.nextDouble();
        System.out.print("Enter distance from viaToFinalCity in miles: ");
        double distance2 = scanner.nextDouble();
        System.out.print("Enter time taken: ");
        double time = scanner.nextDouble();
        System.out.println("Results: " + name + ", " + fromCity + ", " + viaCity + ", " + ioCity + ", " + distance1 + ", " + distance2 + ", " + time);
    }
}
