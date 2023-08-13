package SortingQuestions;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        int[] heights = {1,2,5,4,5};
        int ans = IncorrectOrder(heights);
        System.out.println(ans);
    }
    static int IncorrectOrder(int[] heights){
        int[] originalArray = new int[heights.length];
        System.arraycopy(heights, 0, originalArray, 0, heights.length);
        Arrays.sort(heights);
        int counter = 0;
        for(int i = 0; i < heights.length; i++){
            if(originalArray[i] != heights[i]){
                counter++;
            }
        }
        return counter;
    }
}
