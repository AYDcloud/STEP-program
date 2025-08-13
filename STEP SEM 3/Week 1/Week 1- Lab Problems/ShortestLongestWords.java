import java.util.Scanner; 
public class ShortestLongestWords { 
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
public static int[] findShortestAndLongest(String[][] wordLengths) { 
int shortestIndex = 0; 
int longestIndex = 0; 
int shortestLength = Integer.parseInt(wordLengths[0][1]); 
int longestLength = Integer.parseInt(wordLengths[0][1]); 
for (int i = 1; i < wordLengths.length; i++) { 
int length = Integer.parseInt(wordLengths[i][1]); 
if (length < shortestLength) { 
shortestLength = length; 
shortestIndex = i; 
} 
if (length > longestLength) { 
longestLength = length; 
longestIndex = i; 
} 
} 
return new int[] { shortestIndex, longestIndex }; 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter a sentence: "); 
String input = sc.nextLine(); 
String[] words = customSplit(input); 
String[][] wordLengthPairs = wordsWithLengths(words); 
int[] indices = findShortestAndLongest(wordLengthPairs); 
System.out.println("Shortest word: " + wordLengthPairs[indices[0]][0] + 
" (Length: " + wordLengthPairs[indices[0]][1] + ")"); 
System.out.println("Longest word: " + wordLengthPairs[indices[1]][0] + 
" (Length: " + wordLengthPairs[indices[1]][1] + ")"); 
sc.close(); 
} 
}