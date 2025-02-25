import java.util.Scanner;

public class AmarAkbarAnthony {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter Height of Amar in cm: ");
        int H1 = sc.nextInt();
        System.out.print("Enter Height of Akbar in cm: ");
        int H2 = sc.nextInt();
        System.out.print("Enter Height of Anthony in cm: ");
        int H3 = sc.nextInt();

       
        System.out.print("Enter Age of Amar: ");
        int A1 = sc.nextInt();
        System.out.print("Enter Age of Akbar: ");
        int A2 = sc.nextInt();
        System.out.print("Enter Age of Anthony: ");
        int A3 = sc.nextInt();

        
        int shortest = Math.min(Math.min(H1, H2), H3);
        int tallest = Math.max(Math.max(H1, H2), H3);

      
        int youngest = Math.min(Math.min(A1, A2), A3);
        int oldest = Math.max(Math.max(A1, A2), A3);

        
        System.out.println("Youngest is: " + youngest);
        System.out.println("Oldest is: " + oldest);
        System.out.println("Tallest is: " + tallest);
        System.out.println("Shortest is: " + shortest);

        
    }
}
