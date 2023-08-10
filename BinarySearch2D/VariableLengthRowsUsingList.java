package BinarySearch2D;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class VariableLengthRowsUsingList {
    public static void main(String[] args) {
        ArrayList<int[]> sortedMatrix = new ArrayList<>();
        sortedMatrix.add(new int[]{1, 2, 3, 4, 5, 6}); // Example row
        // Add more rows to the matrix as needed

        System.out.println("Enter Element you want to search: ");
        Scanner input = new Scanner(System.in);
        int target = input.nextInt();

        int[] result = binarySearch2D(sortedMatrix, target);
        if (result[0] == -1 && result[1] == -1) {
            System.out.println("Element not found.");
        } else {
            System.out.println("The element: " + target + " is at index: " + Arrays.toString(result));
        }
    }

    public static int[] binarySearch2D(ArrayList<int[]> matrix, int target) {
        if (matrix.isEmpty()) {
            return new int[]{-1, -1};
        }

        int row = 0;
        int col = matrix.get(0).length - 1;

        while (row < matrix.size() && col >= 0) {
            if (matrix.get(row)[col] == target) {
                return new int[]{row, col};
            } else if (matrix.get(row)[col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return new int[]{-1, -1};
    }
}
