import java.util.Scanner;

public class penAmongStudents {
    public static void main(String[] args) {
        int totalPens = 14;
        int students = 3;
        int pensPerStudent = totalPens / students;
        int remainingPens = totalPens % students;
        System.out.println("Pens per student: " + pensPerStudent);
        System.out.println("Remaining pens: " + remainingPens);
    }
}