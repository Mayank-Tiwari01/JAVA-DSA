package MathematicsAndBitManipulation;
/*
Beats 100 % of users with java, 0MS run time.
O(1) TC and SC.
Everything OG.
Had to look up the formula only.
Write the indentation carefully.
The formula for calculating the sum of a continuous range is “(startNum + endNum) * numCount / 2
The formula to find the sum of n terms in AP is Sn = n/2 (2a+(n−1)d)
 */
public class CalculateMoneyInLeetcodeBank {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(totalMoney(n));
    }
    static int totalMoney(int n) {
        // The Sum of the first week is 28, and then it keeps increasing by 7 in every subsequent week.
        int weeks = n / 7, daysLeft = n % 7;
        //Week money is the sum of n / 7 weeks. So, if days are 23, then it is the sum of 21 days or 3 weeks.
        double weekMoney = ((double) weeks / 2) * ((56) + (weeks - 1) * 7);
        //This is the sum of remaining days. If days are 23, then it is the sum of 2 days. (21 + 2 = 23).
        double remainingDaysMoney = ((weeks + 1) + (weeks + daysLeft)) * ((double) daysLeft / 2);
        return (int) (weekMoney + remainingDaysMoney);
    }
}
