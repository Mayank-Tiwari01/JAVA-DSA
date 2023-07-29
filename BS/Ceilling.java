package BS;

public class Ceilling {
    public static void main(String args[]){
        int[] arr = {2, 5, 8, 11, 14, 17, 20};
        int target = 5;

        int ans = CeillingNum(arr,target);
        System.out.println(ans);

    }

    static int CeillingNum(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;
        if(target > arr[arr.length - 1]){
            return - 1;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] < target){
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }

        }
        
        return arr[start];
    }
}
