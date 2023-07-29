package BS;
//the brute force solution of this problem would be a simple linear search.
public class LowerBound {
    public static void main(String[] args){
        int[] arr = {1,2,2,3,4,5,6,7,8,9,9,9,10,10,11};
        int k = 23;
        System.out.println(ans(arr,k));
    }
    static int ans(int[] arr, int k){
        int start = 0;
        int end = arr.length - 1;
        int ans = arr.length;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] >= k){
                 ans = mid;
                 //there can be repetition
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
