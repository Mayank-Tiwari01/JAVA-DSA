//To find out whether the given String is Palindrome or not.
import java.lang.reflect.Array;
import java.util.Scanner;

public class AssignmentQ8 {
    public static void main(String[] args){
        
        System.out.println("Enter a string: ");

        Scanner input = new Scanner(System.in);
        String s = new String();

        s = input.nextLine();
        int length = s.length();

        char[] array = new char[length];
       
        

        for (int i = 0; i < length; i++){
            //  array = s.toCharArray();
            array[i] = s.charAt(i);
            
        }

        char[] reverse;
        reverse = new char[length];

        for (int i = 0; i < length; i++) {
        reverse[i] = array[length - 1 - i];
        }

        for (int )

    }    

}
