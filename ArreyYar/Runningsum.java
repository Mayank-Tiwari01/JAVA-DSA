package ArreyYar;

import java.util.Scanner;
import java.util.Arrays;

public class Runningsum {
    public static void main(String[] args) {
        
        int[] arr = new int[5];
        Scanner input = new Scanner(System.in);
        

        for ( int i = 0; i < arr.length; i++){
            arr[i] = input.nextInt();
        }

        int start = 0;
        int end = arr.length;
        int sum = 0;
        int[] ans = new int[arr.length]

        System.out.println(arr[0]); 

        for ( int i = 1; i < end ; i++){
            sum = arr[start] + arr[end - end + i];
            ans[i] = sum;
            arr[start] = sum;
        }

        return sum[];
        
        
        input.close();


    }
}

