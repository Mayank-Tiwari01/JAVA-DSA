package DailyLeetcodeTries;
//yeah so....yeah
public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1,1,1,0};
        System.out.println(findMaxLength(nums));
    }
    static int findMaxLength(int[] nums) {
        int len = nums.length;
        int[] oneCount = new int[len + 1];
        int count = 0;
        for (int i = 1; i <= len; i++) {
            count += nums[i - 1];
            oneCount[i] = count;
        }
        int start = 1, end = len;

        while (end - start + 1 >= 2) {
            if ((end - start + 1) % 2 != 0) {
                if (nums[start - 1] == 1 && nums[end - 1] == 1 || nums[start - 1] == 0 && nums[end - 1] == 0)
                    start++;
                else if (nums[start - 1] == 0 && nums[end - 1] == 1) {
                    if (oneCount[end] - oneCount[start - 1] <= (end - start + 1) / 2)
                        start ++;
                    else
                        end--;
                }
                else {
                    if (oneCount[end] - oneCount[start - 1] <= (end - start + 1) / 2)
                        end--;
                    else
                        start++;
                }
            }
            if ((end - start + 1) % 2 == 0) {
                if (oneCount[end] - oneCount[start - 1] == (end - start + 1) / 2)
                    return end - start + 1;
                else if (nums[start - 1] == 1 && nums[end - 1] == 1 || nums[start - 1] == 0 && nums[end - 1] == 0)
                    start++;
                else if (nums[start - 1] == 0 && nums[end - 1] == 1) {
                    if (oneCount[end] - oneCount[start - 1] < (end - start + 1) / 2)
                        start ++;
                    else
                        end--;
                }
                else {
                    if (oneCount[end] - oneCount[start - 1] <= (end - start + 1) / 2)
                        end--;
                    else
                        start++;
                }
            }
        }
        return 0;
    }
}
