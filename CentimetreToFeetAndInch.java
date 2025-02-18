import java.util.Scanner;

public class CentimetreToFeetAndInch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your height in centimeters: ");
        double heightCm = scanner.nextDouble();
        
        double heightInches = heightCm / 2.54;
        double heightFeet = heightInches / 12;
        
        System.out.println("Your height in cm is " + heightCm + ", in feet is " + heightFeet + ", and in inches is " + heightInches);
    }
}
