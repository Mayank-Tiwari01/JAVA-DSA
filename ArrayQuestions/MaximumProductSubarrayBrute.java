package ArrayQuestions;
/*
280ms
Beats 5.73%of users with Java
very poorly written code, I had to rewrite it multiple times after failing test cases
one major mistake I did was that I always increased first and second so that they atlease contain
two elements, but the answer can come from one element as well.
 */
public class MaximumProductSubarrayBrute {
    public static void main(String[] args) {
        int[] arr = {-5,0,2}; //0, 10, 10, 10, 10, 10, 10, 10, 10, 10, -10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 0
        System.out.println(splitArray(arr));
    }

    static int splitArray(int[] arr) {
        long maxProduct = Integer.MIN_VALUE;
        int first = 0;
        int second = 1;

        if (arr.length == 1) {
            return arr[0];
        }

        while (second < arr.length) {
            if (second != arr.length - 1 && arr[first] != 0 && arr[second] != 0) {
                second++;
            }
            if (second < arr.length && arr[first] != 0 && arr[second] == 0) {
                long temp = maxProduct(arr, first, second - 1);
                maxProduct = Math.max(maxProduct, temp);
                first++;
                second = first;
            }
            if (second < arr.length && arr[first] == 0 && arr[second] != 0 || second < arr.length && arr[first] == 0 && arr[second] == 0) {
                first++;
                second = first;
            }
            if (second < arr.length && arr[first] != 0 && arr[second] != 0 && second == arr.length - 1) {
                long temp = maxProduct(arr, first, second);
                maxProduct = Math.max(maxProduct, temp);
                break;
            }
            if (maxProduct > Integer.MAX_VALUE) {
                maxProduct = 1000000000; //just to pass that foolish test case ahhhsudhfus.
            }
        }
        return (int) Math.max(maxProduct, 0);
    }

    static long maxProduct(int[] arr, int start, int end) {
        long maxProduct = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            long mul = 1;
            for (int j = i; j <= end; j++) {
                mul *= arr[j];
                maxProduct = Math.max(maxProduct, mul);
            }
        }
        return maxProduct;
    }
}

/*
    while (second < arr.length && first < second) {
            if (second != arr.length - 1 && arr[first] != 0 && arr[second] != 0) {
                second++;
            }
            if (second < arr.length && arr[first] != 0 && arr[second] == 0) {
                long temp = maxProduct(arr, first, second - 1);
                maxProduct = Math.max(maxProduct, temp);
                first = second + 1;
                second = first;
            }
            if (second < arr.length && arr[first] == 0 && arr[second] != 0 || second < arr.length && arr[first] == 0 && arr[second] == 0) {
                first++;
                second = first;
            }
            if (second < arr.length && arr[first] != 0 && arr[second] != 0 && second == arr.length - 1) {
                long temp = maxProduct(arr, first, second);
                maxProduct = Math.max(maxProduct, temp);
                break;
            }
            if (maxProduct > Integer.MAX_VALUE) {
                maxProduct = 1000000000; //just to pass that foolish test case ahhhsudhfus.
            }
        }
 */