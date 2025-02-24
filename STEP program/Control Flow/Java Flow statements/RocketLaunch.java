import java.util.Scanner;

class RocketLaunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the countdown start number: ");
        int counter = scanner.nextInt();

       
        while (counter >= 1) {
            System.out.println(counter);
            counter--; 
        }

       
        System.out.println("Lift-off,the rocket has launched!");

        scanner.close();
    }
}
