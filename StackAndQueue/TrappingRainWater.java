package StackAndQueue;
/*
Not really a stack problem.
The idea is simple really we find out the absolute max left and right of a given element, the water flowing above it is
what we want to calculate right? So imagine at what height will the water flow above? The min of both maxLeft and maxRight
right? Try visualizing in your head, so the water flowing above is of height Math.min(rightGreatest[i], leftGreatest[i]).
And to find out what water is above the building, you subtract the water height from building height. In max area histogram
we were looking for NGL and NGR, but in this we look for overall/absolute max in the left & right. (My og wrong approach is in the comments below)
https://www.youtube.com/watch?v=FbGG2qpNp4U&list=TLPQMjMwMTIwMjQfi_VL-E2rBA&index=2
https://www.youtube.com/watch?v=f2QgmVxPiS4&list=TLPQMjMwMTIwMjQfi_VL-E2rBA&index=3
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }
    static int trap(int[] height) {
        int len = height.length;
        int[] rightGreatest = RGN(height, len);
        int[] leftGreatest = LGN(height, len);
        int totalWater = 0;

        for (int i = 0; i < len; i++) {
            int sum = Math.min(rightGreatest[i], leftGreatest[i]) - height[i];
            totalWater += Math.max(sum, 0);
        }
        return totalWater;
    }

     static int[] LGN(int[] arr, int len) {
         //will calculate what is the greatest value on the left of a value, if no then the value is the same.
         // i.e., if there is no greater value of 5 on the left, the array will have 5 for 5.
       int[] ans = new int[len];
       ans[0] = arr[0];

       for (int i = 0; i < len - 1; i ++) {
           ans[i + 1] = Math.max(ans[i], arr[i + 1]);
       }
       return ans;
    }

    static int[] RGN(int[] arr, int len) {
        //will calculate what is the greatest value on the right of a value, if no then the value is the same.
        // i.e., if there is no greater value of 5 on the right, the array will have 5 for 5.
        int[] ans = new int[len];
        ans[len - 1] = arr[len - 1];

        for (int i = len - 1; i > 0; i--) {
            ans[i - 1] = Math.max(ans[i], arr[i - 1]);
        }
        return ans;
    }
}
/*
my early thinking which was that we calculate max right and then for every element we can do multiplication of elements in b/w
the element and the max right to the elements and then remove the sum of middle elements, this would work if every
area where water is trapped is unique from each other, no common water trapping.
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }
    static int trap(int[] height) {
        int len = height.length;
        int[] rightGreatest = RGN(height, len);
        int[] prefixSum = prefixSum(height, len);
        int totalWater = 0;

        for (int i = 0; i < len; i++) {
            if (rightGreatest[i] != -1) {
                int storedWater = ((rightGreatest[i] - i)  - 1 ) * height[i];
                int prefix =  (prefixSum[rightGreatest[i]] - prefixSum[i + 1]);
                totalWater += storedWater - prefix; //doing this will calculate water more than one time. (WRONG)
            }
        }
        return totalWater;
    }
    static int[] RGN(int[] arr, int len) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) stack.pop();
            if (stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
        return ans;
    }
    static int[] prefixSum(int[] arr, int len) {
        int[] ans = new int[len + 1];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
            ans[i + 1] = sum;
        }
        return ans;
    }
}

 */

