package ArrayQuestions;
/*
if the question says there can be or cannot be a majority element,
 then we have to check again if the found majorElement occurs more than
  nums.length / 2 or not. so an extra O(n) step.
  for the modified approach to the same algo, see majority element II.
 */
public class BoyerMooreMajorityVoteAlgorithm {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(BoyerMoore(nums));
    }
    static int BoyerMoore(int[] nums){
        int possibleMajor = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                possibleMajor = nums[i];
                count = 1;
            }
            else if(nums[i] == possibleMajor){
                count++;
            }
            else{
                count--;
            }
        }
        return possibleMajor;
    }
}
