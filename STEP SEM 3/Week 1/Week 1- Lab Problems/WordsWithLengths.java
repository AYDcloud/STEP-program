import java.util.Scanner; 
public class WordsWithLengths { 
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
public static String[][] wordsWithLengths(String[] words) { 
String[][] result = new String[words.length][2]; 
for (int i = 0; i < words.length; i++) { 
result[i][0] = words[i]; 
result[i][1] = String.valueOf(getLength(words[i])); 
} 
return result; 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter a sentence: "); 
String input = sc.nextLine(); 
String[] words = customSplit(input); 
String[][] wordLengthPairs = wordsWithLengths(words); 
System.out.printf("%-15s %s\n", "Word", "Length"); 
for (int i = 0; i < wordLengthPairs.length; i++) { 
String word = wordLengthPairs[i][0]; 
int length = Integer.parseInt(wordLengthPairs[i][1]); 
System.out.printf("%-15s %d\n", word, length); 
} 
sc.close(); 
} 
} 