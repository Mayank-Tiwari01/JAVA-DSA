package BinarySearch2D;
/*
In this code, the assumption is that the size of rows in the 2D matrix is fixed.
Each row in the matrix has the same number of columns.
This assumption is important for the binary search approach used in the BinarySearchIn2DArray
 function to work correctly.
 */
import java.util.Scanner;
import java.util.Arrays;

public class RowColMatrix {
    public static void main(String[] args){
        int[][] matrix = {
                {10,20,30,40,50},
                {60,70,80,90,100},
                {110,180,200,400,500},
        };
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number to be searched: ");
        int target = input.nextInt();
        int[] ans = BinarySearchIn2DArray(matrix,target);
        System.out.println("The number: " +target+ " is at: " +Arrays.toString(ans));
    }
    public static int[] BinarySearchIn2DArray(int[][] matrix, int target){
        int row = 0;
        int col = matrix.length - 1;

        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target){
                return new int[]{row,col};
            }
            else if(matrix[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        return new int[]{-1,-1};
    }
}
