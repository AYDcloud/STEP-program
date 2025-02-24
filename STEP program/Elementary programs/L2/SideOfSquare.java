import java.util.Scanner;

class SideOfSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter perimeter of the square: ");
        double perimeter = scanner.nextDouble();

        double side = perimeter / 4;

        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter + ".");
    }
}
