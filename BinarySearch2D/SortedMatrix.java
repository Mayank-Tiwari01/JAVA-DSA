package BinarySearch2D;

import java.util.Scanner;
import java.util.Arrays;
//size of the rows is fixed, wrote this code to understand better.
public class SortedMatrix {
    public static void main(String[] args){
        int[][] sortedMatrix = {
                {1,2,3,4,5,6},
                {7,8},
                {9,10,11,12}
        };
        System.out.println("Enter Element you want to search: ");
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        System.out.println("The element: " +target+ " is at index: " +Arrays.toString(BinarySearch2D(sortedMatrix, target)));
    }
    public static int[] BinarySearch2D(int[][]x, int y){
        if( x.length == 0){
            return new int[]{-1,-1};
        }
        int col = x[0].length - 1;
        int row = 0;

        while(row < x.length && col >= 0){
            if(x[row][col] == y){
                return new int[]{row,col};
            }
            if(x[row][col] < y){
                row++;
            }
            else{
                col--;
            }
        }
        return new int[]{-1,-1};
    }
}
