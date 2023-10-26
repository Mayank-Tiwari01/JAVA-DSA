package Mathematics;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 10000;
        boolean[] isPrime = new boolean[n + 1];
        seive(n, isPrime);
    }

     static void seive(int n, boolean[] isPrime) {
        // we will assume that if the value is false, then the number is prime.
         for (int i = 2; i * i < n; i++) {
             if (!isPrime[i]) {
                 for (int j = i * 2; j < n; j += i) {
                     isPrime[j] = true;
                 }
             }
         }

         for (int i = 2; i < n; i++) {
             if (!isPrime[i]) {
                 System.out.print(i + " ");
             }
         }
    }
}
