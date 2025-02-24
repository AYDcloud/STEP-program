 import java.util.Scanner;

class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();
        double fahrenheitResult = (celsius * 9/5) + 32;
        System.out.println("Temperature in Fahrenheit: " + fahrenheitResult);
    }
}
