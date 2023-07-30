package BS;
//https://leetcode.com/problems/find-in-mountain-array/description/
//I used an ArrayList so that I could code it in intellij
import java.util.ArrayList;
import java.util.Arrays;

public class FindinMountainArray {

    public static void main(String[] args){
        ArrayList<Integer> MountainArray = new ArrayList<>(Arrays.asList(1,2,3,4,5,3,1));
        int target = 3;
        int ans = -1;
        int peakPoint = peakPoint( MountainArray);
        int incline = inclineBSearch(MountainArray, target, peakPoint);
        int decline = declineBSearch(MountainArray, target, peakPoint);
        if(incline!= -1){
            ans = incline;
        }
        else if(declineBSearch(MountainArray, target, peakPoint) != -1 && incline == -1){
            ans = decline;
        }

        System.out.println(ans);
    }
    //method that will tell us the peak point in the array
    static int peakPoint(ArrayList<Integer> MountainArray){
        int start = 0;
        int end = MountainArray.size() - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(MountainArray.get(mid) < MountainArray.get(mid + 1)){
                start = mid + 1;
            }
            else if(MountainArray.get(mid) > MountainArray.get(mid + 1)){
                end = mid;
            }
        }
        int peakpoint = start;
        return peakpoint;
    }
    static int inclineBSearch(ArrayList<Integer> MountainArray, int target, int peakpoint){
        int start = 0;
        int end = peakpoint;
        int foundElementIdx = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(MountainArray.get(mid) == target){
                foundElementIdx = mid;
                return foundElementIdx;
            }
            else if(MountainArray.get(mid) > target){
                end = mid - 1;
            }
            else if (MountainArray.get(mid) < target){
                start = mid + 1;
            }
        }

        return -1;
    }

    static int declineBSearch(ArrayList<Integer> MountainArray, int target, int peakpoint){
        int start = peakpoint + 1;
        int end = MountainArray.size() - 1;
        int foundElementIdx = -1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(MountainArray.get(mid) < target){
                end = mid - 1;
            }
            else if(MountainArray.get(mid) > target){
                start = mid + 1;
            }
            else{
                foundElementIdx = mid;
                return  foundElementIdx;
            }
        }
        return -1;
    }
}
