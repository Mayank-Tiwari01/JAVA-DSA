package BS;

import java.util.ArrayList;
import java.util.Arrays;

public class FindinMountainArray {
    public static void main(String[] args){
        ArrayList<Integer> MountainArray = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 3, 1));
        int target = 2;
        int ans = bSearch(MountainArray, target);
        System.out.println(ans);
    }
    static int bSearch(ArrayList<Integer> MountainArray, int target){
        int start = 0;
        int end = MountainArray.size() - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(MountainArray.get(mid) < target){
                start = mid + 1;
            }
            else if(MountainArray.get(mid) > target){
                end = mid - 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
}
