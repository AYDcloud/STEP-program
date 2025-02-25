import java.util.Scanner;
class VotingAge
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int age;
        System.out.println("Enter age: ");
        age = sc.nextInt();
        if(age>=18)
        {
            System.out.println("Can vote");
        }
        else
        {
            System.out.println("Can't vote");
        }
    }
}
