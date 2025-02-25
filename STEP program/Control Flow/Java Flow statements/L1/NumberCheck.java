import java.util.Scanner;
class NumberCheck
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Enter number: ");
        number = sc.nextInt();
        if(number<0)
        {
            System.out.println(number+" is negative");
        }
        else if(number>0)
        {
            System.out.println(number+" is positive");
        }
        else
        {
            System.out.println(number+" is zero");
        }
    }
}