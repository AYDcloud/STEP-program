import java.util.Scanner;

public class ProfitLoss {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cost price: ");
        double costPrice = scanner.nextDouble();
        System.out.print("Enter selling price: ");
        double sellingPrice = scanner.nextDouble();
        
        double profitLoss = sellingPrice - costPrice;
        double profitLossPercent = (profitLoss / costPrice) * 100;
        
        if (profitLoss > 0) {
            System.out.println("Profit: " + profitLoss + " (" + profitLossPercent + "%)");
        } else {
            System.out.println("Loss: " + Math.abs(profitLoss) + " (" + Math.abs(profitLossPercent) + "%)");
        }
    }
}
