import java.util.Scanner; 
 
public class StringMethods { 
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in); 
 
        // TODO: Ask user for their full name (first and last name) 
        System.out.print("Enter your full name (first and last): "); 
        String fullName = scanner.nextLine().trim(); 
 
        // TODO: Ask user for their favorite programming language 
        System.out.print("Enter your favorite programming language: "); 
        String language = scanner.nextLine().trim(); 
 
       // TODO: Ask user for a sentence about their programming experience 
        System.out.print("Enter a sentence about your programming experience: "); 
        String experience = scanner.nextLine().trim(); 
        // TODO: Process the input: 
        // 1. Extract first and last name separately 
        String firstName = ""; 
        String lastName = ""; 
        String[] nameParts = fullName.split(" ");  
 
        if (nameParts.length >= 2) { 
            firstName = nameParts[0]; 
            lastName = nameParts[nameParts.length - 1];  
        } else if (nameParts.length == 1) { 
            firstName = nameParts[0]; 
            lastName = "(no last name provided)"; 
        } else { 
            firstName = "(no first name)"; 
            lastName = "(no last name)"; 
        } 
 
        // 2. Count total characters in the sentence (excluding spaces) 
        int charCount = experience.replace(" ", "").length(); 
 
        // 3. Convert programming language to uppercase 
        String languageUpper = language.toUpperCase(); 
 
        // 4. Display a formatted summary 
        System.out.println("\n    Summary    "); 
        System.out.println("First Name: " + firstName); 
        System.out.println("Last Name: " + lastName); 
        System.out.println("Favorite Programming Language : " + languageUpper); 
        System.out.println("Programming Experience : " + charCount); 
 
        scanner.close(); 
    } 
} 