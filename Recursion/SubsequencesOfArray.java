package Recursion;
//gpt
public class SubsequencesOfArray {
    public static void main(String[] args) {
        int[] arr = {7,8,9};
        printAllSubsequences(arr, 0, new int[arr.length]);
    }

    static void printAllSubsequences(int[] arr, int index, int[] currentSubset) {
        if (index == arr.length) {
            for (int i = 0; i < currentSubset.length; i++) {
                if (currentSubset[i] == 1) {
                    System.out.print(arr[i] + " ");
                }
            }
            return;
        }

        // Include the current element in the subset
        currentSubset[index] = 1;
        printAllSubsequences(arr, index + 1, currentSubset);

        // Exclude the current element from the subset
        currentSubset[index] = 0;
        printAllSubsequences(arr, index + 1, currentSubset);


    }
}
