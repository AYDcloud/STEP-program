import java.util.Scanner;

public class MeanHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        double[] heights = new double[11];
        double sum = 0.0;

        for (int i = 0; i < 11; i++) {
            System.out.print("Enter the height of player " + (i + 1) + ": ");
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }
        double mean = sum / 11;
        System.out.println("\nMean height of the football team: " + mean);
        sc.close();
    }
}
