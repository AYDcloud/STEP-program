 import java.util.Scanner;

class TotalIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter bonus: ");
        double bonus = scanner.nextDouble();
        double income = salary + bonus;
        System.out.println("Total Income: " + income);
    }
}
