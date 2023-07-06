import java.util.Scanner;

public class AssignmentLeapYear {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year");
        int year = input.nextInt();

        if(isLeapYear (year)) {
            System.out.println("It is a leap year!");
        }

        else{
            System.out.println("not a leap year.");
        }

        input.close();

    }

    public static boolean isLeapYear (int year){

        if ( year % 4 == 0){
            if ( year % 100 == 0 && year % 400 != 0){
                return false;
            }
            return true;
        }
        return false;

    }


}