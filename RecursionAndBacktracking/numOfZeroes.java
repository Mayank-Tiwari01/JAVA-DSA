package RecursionAndBacktracking;
/*
If the last function call returns a value of 6, this value will be propagated up the call stack.
Each level of the call stack contributes its part to the final result, and as the recursion
unwinds, these values are combined or modified accordingly.
Eventually, the final result reaches the initial caller (in your case, the main function).

In the context of your countZeroes function, if the last function call returns 6,
and there were previous recursive calls with their own contributions,
all these values are aggregated and returned to the main function.
The final result is then used as needed, such as printing or further processing.
T and S complexity: O(log n).
 */
public class numOfZeroes {
    public static void main(String[] args) {
        int n = 1009008900;
        System.out.println(countZeroes(n, 0));
        System.out.println(numberOfSteps(n, 0));
    }
    static int countZeroes(int n, int count) {
        if (n == 0) return count;
        int last = n % 10;
        if (last == 0)
            return countZeroes(n / 10, ++count);
        else
           return countZeroes(n / 10, count);
    }
    //number of steps to make a number 0.
    static int numberOfSteps(int num, int c) {
        if (num == 0) return c;

        if (num % 2 == 0)
            return numberOfSteps(num / 2, ++c);

        return numberOfSteps(num - 1, ++c);
    }
}