 import java.util.Scanner;

class ChocolateAmongChildren {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many chocolates: ");
     double numberOfchocolates = scanner.nextDouble();
     System.out.print("How many children: ");
     double numberOfchildren = scanner.nextDouble();
     if (numberOfchocolates == 0) {
        System.out.println("You can't divide by zero!");
       } else if (numberOfchildren != 0) {
     double chocolatesPerChild = numberOfchocolates / numberOfchildren;
     double remaningChocolates = numberOfchocolates % numberOfchildren ;
     System.out.print("The number of choclates each child gets is " + chocolatesPerChild + "and number of remaning chocolates is: " + remaningChocolates);
        }
    }
}
