 import java.util.Scanner;

class SimpleInterest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Principal");
        double Principal = scanner.nextDouble();
        System.out.print("Enter Rate");
        double Rate = scanner.nextDouble();
        System.out.print("Enter Time");
        double Time = scanner.nextDouble();
        double SI = (Principal * Rate * Time) / 100;
        System.out.println("Simple Interest is " + SI + " for Principal " + Principal + " Rate of interest " + Rate + " Time " + Time);
    }
}