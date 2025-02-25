import java.util.Scanner;

class MultiplesBelow100Positive {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt();

        if (number > 0 && number < 100) {
            int counter = number - 1;
            System.out.print("Multiples of " + number + " below 100: ");

            while (counter > 0) {
                if (counter % number == 0) {
                    System.out.print(counter + " ");
                }
                counter--;
            }
        } else {
            System.out.println("Please enter a positive number less than 100.");
        }
    }
}
