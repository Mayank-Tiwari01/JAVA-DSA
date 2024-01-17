package StackAndQueue;
import java.util.*;
public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            indexMap.put(nums1[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (stack.empty() && indexMap.containsKey(nums2[i])) nums1[indexMap.get(nums2[i])] = -1;

            else if (indexMap.containsKey(nums2[i]) && !stack.empty()){
                nums1[indexMap.get(nums2[i])] = stack.peek();
            }
            stack.push(nums2[i]);
        }
        return nums1;
    }
}

