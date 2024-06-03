import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of subjects: ");
        int n = scanner.nextInt();
        
        while (n <= 0) {
            System.out.println("The number of subjects must be greater than zero. Please try again.");
            System.out.print("Enter the number of subjects: ");
            n = scanner.nextInt();
        }

        int[] marks = new int[n];
        int totalMarks = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextInt();
            }
            
            totalMarks += marks[i];
        }
        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / n;

        // Grade Calculation
        char grade = calculateGrade(averagePercentage);

        // Display Results
        System.out.println("\n**** REPORT CARD ****");
        System.out.println("Total Marks: " + totalMarks + " out of " + (n * 100));
        System.out.printf("Average Percentage: "+ averagePercentage);
        System.out.println("\nGrade: " + grade);
        
        scanner.close();
    }
    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
