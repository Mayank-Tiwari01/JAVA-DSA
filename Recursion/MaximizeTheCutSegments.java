package Recursion;
//TC : O(3^n)
public class MaximizeTheCutSegments {
    public static void main(String[] args) {
        System.out.println(maxCut(17, 10, 11, 3));
    }
    static int maxCut(int n, int x, int y, int z) {
        if (n == 0)
            return 0;
        if (n < 0)
            return -1;

        int max = Math.max(maxCut(n - x, x, y, z),
                Math.max(maxCut(n - y, x, y, z), maxCut(n - z, x, y, z)));

        if (max == -1) return -1;
        System.out.println(max + 1);
        return max + 1;
    }
}
