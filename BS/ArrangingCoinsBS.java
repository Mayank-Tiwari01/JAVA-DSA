package BS;

public class ArrangingCoinsBS {
    public static void main(String[] args) {
        long n = 2147483646;
        System.out.println(NumberOfCompleteStairs(n));
    }
    static long NumberOfCompleteStairs(long n){
        long start = 1;
        long end = n;
        long sol = 1;
        while(start <= end){
            long mid = start + (end - start) / 2;
            long CoinsReq = (mid * (mid + 1)) / 2;
            if(CoinsReq > n){
                end = mid - 1;
            }
            else {
                sol = mid;
                start = mid + 1;
            }
        }
        return sol;
    }
}
