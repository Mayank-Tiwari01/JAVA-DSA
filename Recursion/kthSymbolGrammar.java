package Recursion;

public class kthSymbolGrammar {
    public static void main(String[] args) {
        int n = 5;
        int k = 4;
        System.out.println(kThSymbol(n, k));
    }
    static int kThSymbol(int n, int k) {
        if (k == 1 && n == 1) {
            return 0;
        }

        //n - 1 because n will have 2^n-1 element in it.
        int mid = (int) (Math.pow(2, n - 1) / 2);
        if (k <= mid) {
            return kThSymbol(n - 1, k);
        }
        else {
            int symbol = kThSymbol(n-1,k-mid);
            return symbol == 1 ? 0 : 1;
        }
    }
}
