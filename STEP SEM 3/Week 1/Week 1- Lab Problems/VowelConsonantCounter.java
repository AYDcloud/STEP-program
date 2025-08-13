import java.util.Scanner; 
public class VowelConsonantCounter { 
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
public static int[] countVowelsAndConsonants(String text) { 
int vowels = 0; 
int consonants = 0; 
int len = 0; 
try { 
while (true) { 
text.charAt(len); 
len++; 
} 
} catch (IndexOutOfBoundsException e) { 
} 
for (int i = 0; i < len; i++) { 
char c = text.charAt(i); 
String result = checkChar(c); 
if (result.equals("Vowel")) { 
vowels++; 
} else if (result.equals("Consonant")) { 
consonants++; 
} 
} 
return new int[] {vowels, consonants}; 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter a string: "); 
String input = sc.nextLine(); 
int[] counts = countVowelsAndConsonants(input); 
System.out.println("Vowels: " + counts[0]); 
System.out.println("Consonants: " + counts[1]); 
sc.close(); 
} 
}