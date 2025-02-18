import java.util.Scanner;

public class DiscountedFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the course fee: ");
        double fee = scanner.nextDouble();
        System.out.print("Enter the discount percentage: ");
        double discountPercent = scanner.nextDouble();
        
        double discount = fee * (discountPercent / 100);
        double finalFee = fee - discount;
        
        System.out.println("Discount amount: INR " + discount);
        System.out.println("Final discounted fee: INR " + finalFee);
    }
}
