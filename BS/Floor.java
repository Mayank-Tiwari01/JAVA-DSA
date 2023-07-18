package BS;

public class Floor {
    public static void main(String args[]){
        int[] arr = {2, 5, 8, 11, 14, 17, 20};
        int target = 1;

        int ans = FloorNum(arr,target);
        System.out.println(ans);

    }

    static int FloorNum(int arr[], int target){
        int start = 0;
        int end = arr.length - 1;

        if(arr[0] > target){
            return - 1;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return arr[mid];
            }

            if(arr[mid] < target){
                start = mid + 1;
            }

            else {
                end = mid - 1;
            }

        }
        
        return arr[end];
    }
}
