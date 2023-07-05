import java.util.Scanner;

public class leetcode1 {
    public static void main(String[] args) {

        System.out.println("Enter a number");
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int sum = 0;
        int mul = 1;

        while(n!=0){
            int a = n % 10;
            sum = sum + a;
            mul = mul * a;
            n = n / 10;
        }
        int result = mul - sum;
        System.out.println(result);
    }
    
}
