import java.util.Scanner;

class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base of the triangle: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height of the triangle: ");
        double height = scanner.nextDouble();

        double areaInSquareInches = (base * height) / 2;
        double areaInSquareCentimeters = areaInSquareInches * 6.4516;

        System.out.println("The area of the triangle is " + areaInSquareInches + " square inches and " + areaInSquareCentimeters + " square centimeters.");
    }
}
