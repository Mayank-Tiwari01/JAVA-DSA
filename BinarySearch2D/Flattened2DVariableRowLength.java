package BinarySearch2D;
import java.util.Arrays;
import java.util.Scanner;
//time complexity: O(nRows * log maxCols).
//works for variable length.
public class Flattened2DVariableRowLength {
    public static void main(String[] args) {
        int[][] sortedMatrix = {
                {1, 3, 5},
                {7, 8},
                {10, 12, 14, 16},
                {18, 19, 20, 22},
                {33, 44, 55, 66, 77, 88, 99, 110, 120, 130}
        };

        System.out.println("Enter Element you want to search: ");
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();

        int[] ans = binarySearch(sortedMatrix, target);

        if (ans[0] == -1) {
            System.out.println("Element not present in the 2D array.");
        } else {
            System.out.println("The Element: " + target + " is present at: " + Arrays.toString(ans) + " index");
        }
    }
    static int[] binarySearch(int[][] matrix, int target) {
        int numOfRow = matrix.length;
        int firstRow = 0;
        int lastRow = numOfRow - 1;

        while(firstRow <= lastRow){
            //mid will select one of the row
            int mid = firstRow + (lastRow - firstRow) / 2;
            if(matrix[mid].length == 0){
                firstRow = mid + 1;
                continue;
            }
            int numOfColsInCurrentRow = matrix[mid].length;
            int colStart = matrix[mid][0];
            int colEnd = matrix[mid][numOfColsInCurrentRow - 1];
            //checking if the target lies in between the first and last element of the selected row.
            if(colStart <= target && colEnd >= target){
                //we have found the row in which our target element can possibly exist, apply BS here.
                int first = 0;
                int last = numOfColsInCurrentRow - 1;
                while(first <= last){
                    int rowMid = first + (last - first) / 2;
                    if(matrix[mid][rowMid] == target){
                        return new int[]{mid,rowMid};
                    }
                    else if(matrix[mid][rowMid] < target){
                        first = rowMid + 1;
                    }
                    else{
                        last = rowMid - 1;
                    }
                }
                break;
            }
            /*
            if the last element of the selected row was greater than the target then our target possibly
            lies in the previous rows.
             */
            else if(colEnd > target){
                lastRow = mid - 1;
            }
            else if(colStart < target){
                firstRow = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}