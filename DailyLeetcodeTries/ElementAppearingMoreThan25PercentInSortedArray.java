package DailyLeetcodeTries;

public class ElementAppearingMoreThan25PercentInSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        System.out.println(findSpecialInteger(nums));
    }
    static int findSpecialInteger(int[] arr) {
        int length = arr.length;
        int percent25 = (int) ((double) length * 0.25);
        int count = 0;
        for (int i = 0; i < length - 1; i ++) {
            if (count == percent25) return arr[i];
            if (arr[i] == arr[i + 1]) {
                count++;
            }
            else {
                count = 0;
            }
        }
        return arr[length - 1];//because the array will always have the req ans.
    }
}
