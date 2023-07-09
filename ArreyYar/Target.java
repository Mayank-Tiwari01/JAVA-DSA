package ArreyYar;

// import java.util.Arrays;

// public class Target {
//     public static void main(String[] args) {
//         int[] nums = {0, 1, 2, 3, 4};
//         int[] index = {0, 1, 2, 2, 1};
//         int[] targetArray = new int[5];

//         for (int i = 0; i < 5; i++) {
//             if (i >= index[i]) {
//                 targetArray[i] = nums[i];
//             } else {
//                 targetArray[index[i]] = nums[i];
//             }
//         }
//         System.out.println(Arrays.toString(targetArray));
//     }
// }



import java.util.Arrays;

public class Target {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[] index = {0, 1, 2, 2, 1};
        int[] targetArray = new int[nums.length];
        int length = nums.length;

        // for (int i = 0; i < length; i++) {

        //     if (targetArray[index[i]] != 0) {
        //         // Shift elements to the right if the target position is already occupied
        //         for (int j = length - 1; j > index[i]; j--) {
        //             targetArray[j] = targetArray[j - 1];
        //         }
        //     }
        //     targetArray[index[i]] = nums[i];
        // }

        int i = 0;
        int k = 0;

        while (i < length) {
            for (k = length - 1; k > index[i]; k--)
                targetArray[k] = targetArray[k - 1];
            targetArray[index[i]] = nums[i];
            System.out.println(Arrays.toString(targetArray));
            i++;
        }

        
    }
}

