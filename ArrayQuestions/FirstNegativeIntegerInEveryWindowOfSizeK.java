package ArrayQuestions;
import java.util.*;
/*
Everything OG OFC.
I got the approach relatively quick. But I did not apply much brain while implementing it and thus, made a lot of foolish
errors. Major mistakes were: updating window size in every iteration. Updating p if it is out of range, while I should
only update p if it is behind wStart. And I should only update the window size if wEnd < p. A Pretty easy problem but
use some brain while implementing it. Also make sure p does not give index out of bound.
 */
public class FirstNegativeIntegerInEveryWindowOfSizeK {
    public static void main(String[] args) {
        long[] A = {987, 48, 54, 98, 97, 485, 3245, 7845};
        int K = 5;
        int N = A.length;
        System.out.println(Arrays.toString(printFirstNegativeInteger(A, N, K)));
    }
    static long[] printFirstNegativeInteger(long A[], int N, int K) {
        ArrayList<Integer> negIdx = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            if (A[i] < 0) negIdx.add(i);
        }
        int negLen = negIdx.size();
        long[] negValueWindow = new long[N - (K - 1)];
        if (negLen == 0) return negValueWindow;
        int p = 0, i = 0, wStart = 0, wEnd = K - 1;

        while (wEnd < N) {
            int idx = negIdx.get(p);
            if (idx >= wStart && idx <= wEnd) {
                negValueWindow[i++] = A[idx];
                wStart++;
                wEnd++;
            }
            else if(idx > wEnd) {
                negValueWindow[i++] = 0;
                wStart++;
                wEnd++;
            }
            else if (idx < wEnd) {
                p++;
                if (p >= negLen) break;
            }
        }
        return negValueWindow;
    }
}