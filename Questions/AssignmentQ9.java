//To find Armstrong Number between two given number.

public class AssignmentQ9 {
    public static boolean isArmstrongNumber(int number) {
        int originalNumber = number;
        int digits = String.valueOf(number).length();
        int sum = 0;

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    public static void findArmstrongNumbers(int start, int end) {
        System.out.println("Armstrong numbers between " + start + " and " + end + ":");
        for (int number = start; number <= end; number++) {
            if (isArmstrongNumber(number)) {
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) {
        int start = 100;
        int end = 1000;
        findArmstrongNumbers(start, end);
    }
}
