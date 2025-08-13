import java.util.Scanner; 
public class SplitTextComparison { 
public static int getLength(String text) { 
int count = 0; 
try { 
while (true) { 
text.charAt(count); 
count++; 
} 
} catch (IndexOutOfBoundsException e) { 
} 
return count; 
} 
public static String[] customSplit(String text) { 
int len = getLength(text); 
int wordCount = 1; 
for (int i = 0; i < len; i++) { 
if (text.charAt(i) == ' ') { 
wordCount++; 
} 
} 
String[] words = new String[wordCount]; 
int start = 0; 
int wordIndex = 0; 
for (int i = 0; i <= len; i++) { 
if (i == len || text.charAt(i) == ' ') { 
StringBuilder word = new StringBuilder(); 
for (int j = start; j < i; j++) { 
word.append(text.charAt(j)); 
} 
words[wordIndex++] = word.toString(); 
start = i + 1; 
} 
} 
return words; 
} 
public static boolean compareArrays(String[] arr1, String[] arr2) { 
if (arr1.length != arr2.length) { 
return false; 
} 
for (int i = 0; i < arr1.length; i++) { 
if (!arr1[i].equals(arr2[i])) { 
return false; 
} 
} 
return true; 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter a sentence: "); 
String input = sc.nextLine(); 
String[] customWords = customSplit(input); 
String[] builtinWords = input.split(" "); 
boolean isSame = compareArrays(customWords, builtinWords); 
System.out.println("\nCustom Split:"); 
for (String w : customWords) { 
System.out.println(w); 
} 
System.out.println("\nBuilt-in Split:"); 
for (String w : builtinWords) { 
System.out.println(w); 
} 
System.out.println("\nAre both arrays equal? " + isSame); 
} 
} 