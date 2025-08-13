import java.util.Random;
import java.util.Scanner; 
public class VotingEligibility { 
public static int[] generateRandomAges(int n) { 
Random rand = new Random(); 
int[] ages = new int[n]; 
for (int i = 0; i < n; i++) { 
ages[i] = 10 + rand.nextInt(90); 
} 
return ages; 
} 
public static String[][] checkVotingEligibility(int[] ages) { 
int n = ages.length; 
String[][] result = new String[n][2]; 
for (int i = 0; i < n; i++) { 
result[i][0] = String.valueOf(ages[i]); 
if (ages[i] < 0) { 
result[i][1] = "false"; 
} else if (ages[i] >= 18) { 
result[i][1] = "true"; 
} else { 
result[i][1] = "false"; 
} 
} 
return result; 
} 
public static void displayTable(String[][] arr) { 
System.out.printf("%-10s %-10s\n", "Age", "Can Vote"); 
for (int i = 0; i < arr.length; i++) { 
System.out.printf("%-10s %-10s\n", arr[i][0], arr[i][1]); 
} 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter number of students: "); 
int n = sc.nextInt(); 
System.out.print("Do you want to enter ages manually? (yes/no): "); 
sc.nextLine(); 
String choice = sc.nextLine(); 
int[] ages; 
if (choice.equalsIgnoreCase("yes")) { 
ages = new int[n]; 
for (int i = 0; i < n; i++) { 
System.out.print("Enter age for student " + (i + 1) + ": "); 
ages[i] = sc.nextInt(); 
} 
} else { 
ages = generateRandomAges(n); 
System.out.println("Random ages generated:"); 
for (int age : ages) { 
System.out.print(age + " "); 
} 
System.out.println(); 
} 
String[][] eligibility = checkVotingEligibility(ages); 
displayTable(eligibility); 
sc.close(); 
} 
}