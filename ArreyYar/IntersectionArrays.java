package ArreyYar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;

public class IntersectionArrays {
    public static void main(String[] args){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(Intersection(nums1, nums2)));
    }
    static int[] Intersection(int[] nums1, int[] nums2){
        HashSet<Integer> intersection = new HashSet<>();

        for(int array1 : nums1){
            for(int array2 : nums2){
                if(array1 == array2){
                    intersection.add(array1);
                }
            }
        }
        int [] finalAns = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            finalAns[index] = num;
            index++;
        }
        return finalAns;
    }
}
