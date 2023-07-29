package BS;
//the brute force solution of this problem would be a simple linear search.
public class UpperBound {
    public static void main(String[] args){
        int[] arr = {1,2,2,3,4,5,6,7,8,9,9,9,10,10,13};
        int x = 14;
        System.out.println(ans(arr,k));
    }
    static int ans(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > x){
                ans = mid;
                //there can be repetition or better ans
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
