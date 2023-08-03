package BS;

public class ArrangingCoinsBS {
    public static void main(String[] args) {
        int n = 9;
        System.out.println(NumberOfCompleteStairs(n));
    }
    static int NumberOfCompleteStairs(int n){
        int start = 1;
        int end = n;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int CoinsReq = (mid * (mid + 1)) / 2;
            if(CoinsReq > n){
                end = mid - 1;
            }
            else if(CoinsReq < n){
                start = mid + 1;
            }
        }
        return end;
    }
}
