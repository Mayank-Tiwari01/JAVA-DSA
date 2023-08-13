package SortingQuestions;

import java.util.ArrayList;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        //Array will only have 0,1 or 2.
        int numOfZero = 0;
        int numOfOne = 0;
        int numOfTwo = 0;

        for (int num : nums) {
            if (num == 0) {
                numOfZero++;
            } else if (num == 1) {
                numOfOne++;
            } else {
                numOfTwo++;
            }
        }
        ArrayList<Integer> sortedC = new ArrayList<>();
        int totalElements = numOfOne + numOfTwo + numOfZero;

        int counterForZero = 0;
        int counterForOne = 0;
        int counterForTwo = 0;

        for(int i = 0; i < totalElements; i++){
            if(counterForZero != numOfZero){
                sortedC.add(0);
                counterForZero++;
                continue;
            }
            if(counterForOne != numOfOne){
                    sortedC.add(1);
                    counterForOne++;
                    continue;
            }
            if(counterForTwo != numOfTwo) {
                sortedC.add(2);
                counterForTwo++;
            }
        }
        System.out.println(sortedC);
    }
}


