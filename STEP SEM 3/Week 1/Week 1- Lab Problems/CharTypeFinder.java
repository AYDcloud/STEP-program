import java.util.Scanner; 
public class CharTypeFinder { 
public static String checkChar(char c) { 
if (c >= 'A' && c <= 'Z') { 
c = (char)(c + 32); 
} 
if (c >= 'a' && c <= 'z') { 
if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') { 
return "Vowel"; 
} else { 
return "Consonant"; 
} 
} 
return "Not a Letter"; 
} 
public static String[][] analyzeString(String text) { 
int length = 0; 
try { 
while (true) { 
text.charAt(length); 
length++; 
} 
} catch (IndexOutOfBoundsException e) { 
} 
String[][] result = new String[length][2]; 
for (int i = 0; i < length; i++) { 
char c = text.charAt(i); 
result[i][0] = String.valueOf(c); 
result[i][1] = checkChar(c); 
} 
return result; 
} 
public static void displayTable(String[][] arr) { 
System.out.printf("%-10s %s\n", "Character", "Type"); 
for (int i = 0; i < arr.length; i++) { 
System.out.printf("%-10s %s\n", arr[i][0], arr[i][1]); 
} 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter a string: "); 
String input = sc.nextLine(); 
String[][] analysis = analyzeString(input); 
displayTable(analysis); 
sc.close(); 
} 
} 
