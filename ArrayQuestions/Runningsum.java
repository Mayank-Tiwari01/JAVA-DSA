package ArrayQuestions;

import java.util.Scanner;
import java.util.Arrays;

public class Runningsum {
    public static void main(String[] args) {
        
        int[] arr = new int[5];
        Scanner input = new Scanner(System.in);
        

        for ( int i = 0; i < arr.length; i++){
            arr[i] = input.nextInt();
        }

        int end = arr.length;

        for ( int i = 1; i < end; i++){
            arr[i] = arr[i - 1] + arr[i];
        }

        System.out.println(Arrays.toString(arr));


    }
}

