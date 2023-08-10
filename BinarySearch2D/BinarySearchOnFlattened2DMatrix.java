package BinarySearch2D;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchOnFlattened2DMatrix {
    public static void main(String[] args) {
        int[][] sortedMatrix = {
                {1,2,3,4,5,6},
                {7,8,9,10,11,12},
                {13,14,15,16,17,18,19}
        };
        System.out.println("Enter Element you want to search: ");
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();
        int[] ans = BinarySearchOnFlattenedMatrix(sortedMatrix, target);
        if(ans[0] == -1){
            System.out.println("Element not present in the 2D array.");
        }
        else{
            System.out.println("The Element: " +target+ " is present at: " + Arrays.toString(ans)+ " index");
        }
    }
    static int[] BinarySearchOnFlattenedMatrix(int[][] sortedMatrix, int target){
        int nRows = sortedMatrix.length;
        int nCols = sortedMatrix[0].length;
        if(nCols == 0){
            return new int[]{-1,-1};
        }
        int low = 0;
        int high = nRows * nCols - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int row = mid / nCols;
            int col = mid % nCols;
            if(sortedMatrix[row][col] == target){
                return new int[]{row,col};
            }
            if(sortedMatrix[row][col] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
}
