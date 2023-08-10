package BinarySearch2D;
import java.util.Arrays;
import java.util.Scanner;

//works for variable length.
public class Flattened2DVariableRowLength {
    public static void main(String[] args) {
        int[][] sortedMatrix = {
                {1, 3, 5},
                {7, 8},
                {10, 12, 14, 16},
                {18, 19, 20, 2222}
        };

        System.out.println("Enter Element you want to search: ");
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();

        int[] ans = BinarySearchOnFlattenedMatrix(sortedMatrix, target);

        if (ans[0] == -1) {
            System.out.println("Element not present in the 2D array.");
        } else {
            System.out.println("The Element: " + target + " is present at: " + Arrays.toString(ans) + " index");
        }
    }

    static int[] BinarySearchOnFlattenedMatrix(int[][] sortedMatrix, int target) {
        int nRows = sortedMatrix.length;
        int low = 0;
        int high = nRows - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

//            if (sortedMatrix[mid].length == 0) {
//                low = mid + 1;
//                continue;
//            }

            int nCols = sortedMatrix[mid].length;
            int first = sortedMatrix[mid][0];
            int last = sortedMatrix[mid][nCols - 1];

            if (first <= target && target <= last) {
                // Perform binary search within the row
                int left = 0;
                int right = nCols - 1;
                while (left <= right) {
                    int colMid = left + (right - left) / 2;
                    if (sortedMatrix[mid][colMid] == target) {
                        return new int[]{mid, colMid};
                    } else if (sortedMatrix[mid][colMid] < target) {
                        left = colMid + 1;
                    } else {
                        right = colMid - 1;
                    }
                }
                break; // Target not found in this row
            } else if (target < first) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
