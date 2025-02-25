import java.util.Scanner;

public class BonusSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Salary and Years of Service: ");
        int salary = sc.nextInt();
        int years = sc.nextInt();
        
        double bonus = (years / 100.0) * salary; 
        
        System.out.println("Bonus is: " + bonus);
        
        
    }
}
