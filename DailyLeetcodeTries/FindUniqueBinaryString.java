package DailyLeetcodeTries;
/*
Runtime
0ms
Beats 100.00%of users with Java
(Read in the comments that this question can use Cantor's diagonal argument.
Tried implementing it, and it worked)
 */
public class FindUniqueBinaryString {
    public static void main(String[] args) {
        String[] nums = {"111","011","001"};
        System.out.println(uniqueBinaryByGPT(nums));
    }
    static String optimizedApproach(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].charAt(i) == '1') {
                ans.append('0');
            }
            else {
                ans.append('1');
            }
        }
        return ans.toString();
    }
    static String uniqueBinaryByGPT(String[] nums) {
        StringBuilder diagonalNum = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            diagonalNum.append(nums[i].charAt(i));
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < diagonalNum.length(); i++) {
            ans.append(diagonalNum.charAt(i) == '1' ? '0' : '1');
        }

        return ans.toString();
    }
    static String myOriginalPoorlyWrittenCode(String[] nums) {
        String diagonalNum = "";
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            String element = nums[i];
            for (int j = 0; j < element.length(); j++) {
                diagonalNum += element.charAt(index);
                break;
            }
            index++;
        }
        String ans = "";
        for (int i = 0; i < diagonalNum.length(); i++) {
            if (diagonalNum.charAt(i) == '1') {
                ans += '0';
            }
            else {
                ans += '1';
            }
        }
        return ans;
    }
}

