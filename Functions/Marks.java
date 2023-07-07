import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        System.out.print("How many subjects?: ");

        Scanner input = new Scanner(System.in);
        int numberOfMarks = input.nextInt();

        System.out.println("Enter " + numberOfMarks + " subjects total marks (out of 100):");
        int totalMarks = 0;

        for (int i = 0; i < numberOfMarks; i++) {
            totalMarks += input.nextInt();
        }

        int percentage = calculatePercentage(totalMarks, numberOfMarks);
        String grade = calculateGrade(percentage);

        System.out.println("Your percentage is: " + percentage);
        System.out.println("Your grade is: " + grade);

        input.close();
    }

    static int calculatePercentage(int totalMarks, int numberOfMarks) {
        int percentage = (totalMarks * 100) / (numberOfMarks * 100);
        return percentage;
    }

    static String calculateGrade(int percentage) {
        if (percentage > 89) {
            return "A+";
        } else if (percentage > 79) {
            return "A";
        } else if (percentage > 69) {
            return "B+";
        } else if (percentage > 59) {
            return "B";
        } else if (percentage > 49) {
            return "C";
        } else if (percentage > 39) {
            return "D";
        } else {
            return "You did not pass the exam.";
        }
    }
}
