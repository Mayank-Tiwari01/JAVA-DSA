package BS;

public class CorrectPalindome {
    public static void main(String[] args) {
        int x = 12121;
        if(isPalindrome(x)){
            System.out.println("True");
        }
        else{
            System.out.println("false");
        }

    }
    static boolean isPalindrome(int x) {
        if (x == 0 || x < 0 || x % 10 == 0) {
            return false;
        }
        int temp = 0;
        while(temp < x){
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        return (x == temp || x == temp / 10);
    }
}
