import java.util.Scanner;

class GreatestFactor {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        
        for (int i = num / 2; i >= 1; i--) {
            if (num % i == 0) {
                System.out.println("Greatest factor: " + i);
                break;
            }
        }
    }
}
