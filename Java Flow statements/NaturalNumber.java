import java.util.Scanner;
class NaturalNumber
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num1, num2 ,sum=0;
        System.out.println("Enter number and the number of natural numbers: ");
        num1 = sc.nextInt();
        if(num1>0)
        {
            System.out.println(num1+" is a Natural Number");
        }
        num2 = sc.nextInt();
        for(int i=1;i<=num2;i++)
        {
            sum+=i;
        }
        System.out.println("Sum is: "+sum);
    }
}

