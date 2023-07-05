//To find out whether the given String is Palindrome or not.
import java.util.Scanner;

public class AssignmentQ8 {
    public static boolean isPalindrome(String s) {
        int length = s.length();

        char[] array = new char[length];

        for (int i = 0; i < length; i++) {
            array[i] = s.charAt(i);
            // array = s.toCharArray();
        }

        char[] reverse = new char[length];

        for (int i = 0; i < length; i++) {
            reverse[i] = array[length - 1 - i];
        }

        for (int j = 0; j < length; j++) {
            if (array[j] != reverse[j]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();

        if (isPalindrome(s)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
    
}






// import java.util.Scanner;

// public class AssignmentQ8 {
//     public static boolean IsPalindrome(String s){
        
//         System.out.println("Enter a string: ");

//         Scanner input = new Scanner(System.in);
        

//         s = input.nextLine();
//         int length = s.length();

//         char[] array = new char[length];
       
        

//         for (int i = 0; i < length; i++){
//             //  array = s.toCharArray();
//             array[i] = s.charAt(i);
            
//         }

//         char[] reverse;
//         reverse = new char[length];

//         for (int i = 0; i < length; i++) {
//         reverse[i] = array[length - 1 - i];
//         }

//         for (int j = 0; j < length; j++) {

//             if ( array[j] == reverse[j])
//             {
//                 return true; 
//             }

//             else{
//                 return false;
//             }

//         }

//         return true;
       

       

//     }
    
//     public static void main(String[] args){
        
//         if(IsPalindrome(null)){
//             System.out.println("The string is a palindrome.");

//         }

//         else{
//             System.out.println("The string is not a palindrome.");
     
//         }

//     }
    
    

// }
