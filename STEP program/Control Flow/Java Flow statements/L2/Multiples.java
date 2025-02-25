import java.util.Scanner;

class Multiples {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        System.out.print("Multiples of " + num + " below 100: ");
        for (int i = num; i < 100; i += num) {
            System.out.print(i + " ");
        }
    }
}
