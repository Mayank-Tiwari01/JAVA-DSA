package Recursion;

import java.util.ArrayList;

public class easyArrayQuestionsUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,1,1,1,3,4,5,1};

        System.out.println(isSorted(arr, 0, arr.length));

        //will return the first occurrence.
        System.out.println(linearSearch(arr, 0, arr.length, 1));

        ArrayList<Integer> ans = new ArrayList<>();
        //will return all the occurrences.
        linearSearchAllOcc(arr, 0, arr.length, 1, ans);
        System.out.println(ans);

        /*
        do not use this because it is inefficient, as it creating an array list in every function call
        wrote it just for educational and learning purpose.
         */
        System.out.println(linearSearchAllOcc1(arr, 0, arr.length, 1));
    }
    static boolean isSorted(int[] arr, int idx, int len) {
        if (idx == len - 1)
            return true;
        if (arr[idx] > arr[idx + 1])
            return false;
        return isSorted(arr, ++idx, len);
    }
    static int linearSearch(int[] arr, int idx, int len, int target) {
        if (idx == len)
            return - 1;
        if (arr[idx] == target)
            return idx;
        return linearSearch(arr, ++idx, len, target);
    }
    static void linearSearchAllOcc(int[] arr, int idx, int len, int target, ArrayList<Integer> ans) {
        if (idx == len)
            return;
        if (arr[idx] == target)
            ans.add(idx);
        linearSearchAllOcc(arr, ++idx, len, target, ans);
    }
    static  ArrayList<Integer> linearSearchAllOcc1(int[] arr, int idx, int len, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (idx == len)
            return ans;
        if (arr[idx] == target)
            ans.add(idx);
        ArrayList<Integer> allAns = linearSearchAllOcc1(arr, ++idx, len, target);

        ans.addAll(allAns);
        return ans;
    }
}
