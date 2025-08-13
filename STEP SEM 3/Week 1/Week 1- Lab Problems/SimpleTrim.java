import java.util.Scanner; 
public class SimpleTrim { 
public static int getLength(String s) { 
int count = 0; 
while (true) { 
try { 
s.charAt(count); 
count++; 
} catch (Exception e) { 
break; 
} 
} 
return count; 
} 
public static int[] findTrimIndices(String s) { 
int len = getLength(s); 
int start = 0; 
while (start < len && s.charAt(start) == ' ') { 
start++; 
} 
int end = len - 1; 
while (end >= start && s.charAt(end) == ' ') { 
end--; 
} 
return new int[]{start, end}; 
} 
public static String substringCustom(String s, int start, int end) { 
String result = ""; 
for (int i = start; i <= end; i++) { 
result += s.charAt(i); 
} 
return result; 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter string: "); 
String input = sc.nextLine(); 
int[] indices = findTrimIndices(input); 
String trimmed = ""; 
if (indices[0] <= indices[1]) { 
trimmed = substringCustom(input, indices[0], indices[1]); 
} 
System.out.println("Trimmed string: \"" + trimmed + "\""); 
System.out.println("Built-in trim: \"" + input.trim() + "\""); 
System.out.println("Are both equal? " + trimmed.equals(input.trim())); 
sc.close(); 
} 
} 