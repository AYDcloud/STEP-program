import java.util.Scanner;

public class RocketLaunchForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the countdown start number: ");
        int counter = scanner.nextInt();

        
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        
        System.out.println("Lift-off,the rocket has launched!");

        scanner.close(); 
    }
}
