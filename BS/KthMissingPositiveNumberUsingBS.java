package BS;

public class KthMissingPositiveNumberUsingBS {
    public static void main(String[] args){
        int[] arr = {2};
        int k = 1;
        System.out.println(binarySearch(arr, k));
    }
    static int binarySearch(int[] arr, int k){
        int start = 0;
        int end = arr.length - 1;
        if((arr[end] - 1) - (end) < k){
            int x = (arr[end] - 1) - (end);
            while(x < k){
                arr[end]++;
                x++;
            }
            return arr[end];
        }while(start <= end){
            int mid = start + (end - start) / 2;
            if((arr[mid] - 1) - (mid) < k && (arr[mid + 1] - 1) - (mid + 1) >= k && (mid + 1) < arr.length && mid < arr.length){
                int x = (arr[mid] - 1) - mid;
                while(x < k){
                    arr[mid]++;
                    x++;
                }
                return arr[mid];
            }
            if((arr[mid] - 1) - (mid) < k && (arr[mid + 1] - 1) - (mid + 1) < k && (mid + 1) < arr.length && mid < arr.length){
                start = mid + 1;
            }
            if((arr[mid] - 1) - (mid) >= k && (arr[mid + 1] - 1) - (mid + 1) >= k && (mid + 1) < arr.length && mid < arr.length){
                end = mid - 1;
            }
        }
        return -1;
    }
}
