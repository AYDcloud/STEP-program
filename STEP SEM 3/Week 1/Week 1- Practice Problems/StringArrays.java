public class StringArrays { 
    // TODO: Create a method that takes a string array of names 
    // and returns the longest name 
    public static String findLongestName(String[] names) { 
        String longest = ""; 
        for (String name : names) { 
            if (name.length() > longest.length()) { 
                longest = name; 
            } 
        } 
        return longest; 
    } 
 
    // TODO: Create a method that counts how many names 
    // start with a given letter (case-insensitive) 
    public static int countNamesStartingWith(String[] names, char letter) { 
        int count = 0; 
        char lowerLetter = Character.toLowerCase(letter); 
        for (String name : names) { 
            if (!name.isEmpty() && Character.toLowerCase(name.charAt(0)) == 
lowerLetter) { 
                count++; 
            } 
        } 
        return count; 
    } 
 
    // TODO: Create a method that formats all names to "Last, First" format 
    // Assume names are given as "First Last" 
    public static String[] formatNames(String[] names) { 
        String[] formatted = new String[names.length]; 
        for (int i = 0; i < names.length; i++) { 
            String[] parts = names[i].split(" "); 
            if (parts.length >= 2) { 
                formatted[i] = parts[1] + ", " + parts[0]; 
            } else { 
                formatted[i] = names[i]; 
            } 
        } 
        return formatted; 
    } 
 
    public static void main(String[] args) { 
        String[] students = {"John Smith", "Alice Johnson", "Bob Brown", "Carol Davis"}; 
        // TODO: Test all your methods and display results 
        System.out.println("Longest name: " + findLongestName(students)); 
        char letter = 'C'; 
        System.out.println("Names starting with '" + letter + "': " + 
countNamesStartingWith(students, letter)); 
        String[] formatted = formatNames(students); 
        System.out.println("Formatted names:"); 
        for (String name : formatted) { 
            System.out.println(name); 
        } 
    } 
}