package DailyLeetcodeTries;
// tried solving a dp problem with a greedy method, I guess and passed 257/283 test cases.
public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        int[] cost = {0,1,2,2}; //should give 2 but gives 3.
        int case1 =  minCost (cost,0 );
        int case2 = minCost (cost,1);
        System.out.println(Math.min(case1, case2));
    }
    static int minCost (int[] cost, int pointer) {
        int caseX = 0;
        int lastStep = cost.length;

        while (pointer < lastStep) {
            if (pointer + 2 < lastStep && cost[pointer + 1] >= cost[pointer + 2]) {
                caseX += cost[pointer];
                pointer += 2;
            }
            else if (pointer + 2 < lastStep && cost[pointer + 1] < cost[pointer + 2]) {
                caseX += cost[pointer];
                pointer += 1;
            }
            if ( pointer == lastStep - 1 || pointer == lastStep - 2) {
                caseX += cost[pointer];
                pointer = lastStep;
            }
        }
        return caseX;
    }
}