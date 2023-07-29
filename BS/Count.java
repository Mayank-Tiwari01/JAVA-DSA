package BS;

public class Count {
    public static void main(String[] args){
        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4};
        int target = 5;
        int first = Occurence(arr,target,true);
        int last = Occurence(arr,target,false);
        int count = last - first + 1;
        System.out.println(count);
    }
    static int Occurence(int[]arr,int target, boolean firstOccurence){
        int start = 0;
        int end = arr.length - 1;
        int occurenceFirst = -1;

        if(arr[end] < target){
            return -1;
        }
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                occurenceFirst = mid;
                if(firstOccurence){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return occurenceFirst;
    }
}

