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
/*
more optimised:
 HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();
        // Add elements of nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Find the intersection of set1 and nums2
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        // Convert the intersection set to an array
        int[] finalAns = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            finalAns[index] = num;
            index++;
        }

        return finalAns;
    }
}

 */
