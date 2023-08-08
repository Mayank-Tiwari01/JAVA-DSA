package BS;

public class KthMissingPositiveNumberUsingBS {
    public static void main(String[] args){
        int[] arr = {2};
        int k = 1;
        System.out.println(binarySearch(arr, k));
    }
    static int binarySearch(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int lastElement = arr.length - 1;
        int firstElement = 0;
        if ((arr[firstElement] - 1) - firstElement >= k) {
            return k;
        }

        if ((arr[lastElement] - 1) - (lastElement) < k) {
            int x = (arr[lastElement] - 1) - (lastElement);
            while (x < k) {
                arr[lastElement]++;
                x++;
            }
            return arr[lastElement];
        }

            while (start <= end) {
                int mid = start + (end - start) / 2;
                if ((arr[mid] - 1) - (mid) < k && (arr[mid + 1] - 1) - (mid + 1) >= k && (mid + 1) < arr.length && mid < arr.length) {
                    int x = (arr[mid] - 1) - mid;
                    while (x < k) {
                        arr[mid]++;
                        x++;
                    }
                    return arr[mid];
                }
                if ((arr[mid] - 1) - (mid) < k && (arr[mid + 1] - 1) - (mid + 1) < k && (mid + 1) < arr.length && mid < arr.length) {
                    start = mid + 1;
                }
                if ((arr[mid] - 1) - (mid) >= k && (arr[mid + 1] - 1) - (mid + 1) >= k && (mid + 1) < arr.length && mid < arr.length) {
                    end = mid - 1;
                }
            }
            return -1;
        }
    }
