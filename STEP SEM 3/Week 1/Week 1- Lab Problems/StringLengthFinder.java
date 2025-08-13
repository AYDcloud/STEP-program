import java.util.Scanner; 
public class StringLengthFinder { 
public static int findLength(String str) { 
int count = 0; 
while (true) { 
try { 
str.charAt(count); 
count++; 
} catch (IndexOutOfBoundsException e) { 
break; 
} 
} 
return count; 
} 
public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in); 
System.out.println("Enter a string:"); 
String input = scanner.next(); 
int lengthWithoutMethod = findLength(input); 
int lengthWithMethod = input.length(); 
System.out.println("Length without using length(): " + 
lengthWithoutMethod); 
System.out.println("Length using length(): " + lengthWithMethod); 
scanner.close(); 
} 
} 