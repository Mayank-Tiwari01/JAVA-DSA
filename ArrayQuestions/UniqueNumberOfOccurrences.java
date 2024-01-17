package ArrayQuestions;

public class UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        int[] nums= {1,2,3,4,55,5,55,1,1,12,2};
    }
    static boolean uniqueOccurrences(int[] arr) {
        int[] numsFreq = new int[2001];
        int[] freqCheck = new int[2001];

        for (int i : arr) {
            numsFreq[i + 1000]++;
        }

        for (int i : numsFreq) {
            if (freqCheck[i] > 0) return false;
            else freqCheck[i] = i;
        }
        return true;
    }
}