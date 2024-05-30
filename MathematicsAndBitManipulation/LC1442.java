package MathematicsAndBitManipulation;
//https://www.youtube.com/watch?v=TgkxnZ6oPYU
public class LC1442 {
    static int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];

                if (xor == 0) count += (j - i);
            }
        }
        return count;
    }
}
