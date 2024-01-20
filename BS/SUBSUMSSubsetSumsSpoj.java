//package BS;
//
//import java.util.*;
//
//public class SUBSUMSSubsetSumsSpoj {
//    public static void main(String[] args) {
//        int N = 3;
//        int A = -1;
//        int B = 2;
//
//    }
//     static List<Integer> calculateSubsetSums(int N, int start, int end, List<Integer> subsetSums) {
//        List<Integer> subsetSums = new ArrayList<>();
//
//        for (int i = 0; i < (1 << (end - start)); i++) {
//            int sum = 0;
//            for (int j = 0; j < (end - start); j++) {
//                if ((i & (1 << j)) != 0) {
//                    sum += (start + j + 1);
//                }
//            }
//            subsetSums.add(sum);
//        }
//
//        return subsetSums;
//    }
//    static int findSumInRangeBS(int N, int start, int end) {
//        List<Integer> subsetSums1 = new ArrayList<>();
//        List<Integer> subsetSums2 = new ArrayList<>();
//
//        calculateSubsetSums(N, 0, N / 2, subsetSums1);
//        calculateSubsetSums(N, N / 2, N, subsetSums2);
//    }
//}