package BS;

public class ArrangingCoinsBruteForce {
    public static void main(String[] args){
        int n = 2147483647;
        System.out.println(NumberOfCompleteStairs(n));
    }
    static int NumberOfCompleteStairs(int n){
        int count = 0;
        int temp = 1;
        while( n - temp >= 0){
            n = n - temp;
            count++;
            temp++;
        }
        return count;
    }
}
