import java.util.Scanner; 
public class RockPaperScissors { 
public static int getComputerChoice() { 
return (int) (Math.random() * 3); 
} 
public static int findWinner(int userChoice, int compChoice) { 
if (userChoice == compChoice) return 0; 
if ((userChoice == 0 && compChoice == 2) || 
(userChoice == 1 && compChoice == 0) || 
(userChoice == 2 && compChoice == 1)) { 
return 1; 
} else { 
return 2; 
} 
} 
public static String[][] getStats(int totalGames, int userWins, int compWins, 
int ties) { 
double userPercent = totalGames > 0 ? (userWins * 100.0) / totalGames 
: 0; 
double compPercent = totalGames > 0 ? (compWins * 100.0) / 
totalGames : 0; 
double tiePercent = totalGames > 0 ? (ties * 100.0) / totalGames : 0; 
return new String[][] { 
{"Total Games", String.valueOf(totalGames)}, 
{"Player Wins", userWins + " (" + String.format("%.2f", userPercent) + 
"%)"}, 
{"Computer Wins", compWins + " (" + String.format("%.2f", 
compPercent) + "%)"}, 
{"Ties", ties + " (" + String.format("%.2f", tiePercent) + "%)"} 
}; 
} 
public static void displayResults(String[][] results, String[][] stats) { 
System.out.println("Game\tPlayer\tComputer\tResult"); 
for (int i = 0; i < results.length; i++) { 
System.out.printf("%d\t%s\t%s\t\t%s\n", i + 1, results[i][0], results[i][1], 
results[i][2]); 
} 
System.out.println("\nSummary:"); 
for (String[] row : stats) { 
System.out.printf("%-15s : %s\n", row[0], row[1]); 
} 
} 
public static String choiceToString(int choice) { 
switch (choice) { 
case 0: return "Rock"; 
case 1: return "Paper"; 
case 2: return "Scissors"; 
default: return ""; 
} 
} 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter number of games: "); 
int n = sc.nextInt(); 
String[][] gameResults = new String[n][3]; 
int userWins = 0, compWins = 0, ties = 0; 
for (int i = 0; i < n; i++) { 
System.out.print("Enter your choice (0=Rock, 1=Paper, 2=Scissors): "); 
int userChoice = sc.nextInt(); 
int compChoice = getComputerChoice(); 
int winner = findWinner(userChoice, compChoice); 
String result; 
if (winner == 0) { 
result = "Tie"; 
ties++; 
} else if (winner == 1) { 
result = "Player Wins"; 
userWins++; 
} else { 
result = "Computer Wins"; 
compWins++; 
} 
gameResults[i][0] = choiceToString(userChoice); 
gameResults[i][1] = choiceToString(compChoice); 
gameResults[i][2] = result; 
} 
String[][] stats = getStats(n, userWins, compWins, ties); 
displayResults(gameResults, stats); 
sc.close(); 
} 
}