package DailyLeetcodeTries;

public class MinimumAmountOfTimeToCollectGarbage {
    public static void main(String[] args) {
        String[] garbage = {"MMM","PGM","GP"};
        int[] travel = {3,10};
        System.out.println(minTimeReq(garbage, travel));
        System.out.println(iDidNotKnowContainsExist(garbage, travel));
    }
    static int minTimeReq(String[] garbage, int[] travel) {
        int totalTime = 0, mTime = 0, pTime = 0, gTime = 0, totalGarbage = garbage[0].length();

        if (garbage.length == 1) {
            return totalGarbage;
            /*
            since 2 <= garbage.length <= 105, you do not really need this line but write just in case.
             */
        }

        int travelIdx = 0;
        for (int i = 1; i < garbage.length; i++) {
            boolean mPresent = false, pPresent = false, gPresent = false;
            int length = garbage[i].length();
            totalGarbage += length;
            totalTime += travel[travelIdx];
            for (int j = 0; j < length; j++) {
                if (mPresent && pPresent && gPresent) break;
                if (garbage[i].charAt(j) == 'M') {
                    mTime = totalTime;
                    mPresent = true;
                }
                else if (garbage[i].charAt(j) == 'P') {
                    pTime = totalTime;
                    pPresent = true;
                }
                else if (garbage[i].charAt(j) == 'G') {
                    gTime = totalTime;
                    gPresent = true;
                }
            }
            travelIdx++;
        }
        return  totalGarbage + mTime + pTime + gTime;
    }
    static int iDidNotKnowContainsExist(String[] garbage, int[] travel) {
        int totalTime = 0, idx = 0, mTime = 0, pTime = 0, gTime = 0, totalGarbage = garbage[0].length();

        for (int i = 1; i < garbage.length; i++) {
            totalGarbage += garbage[i].length();
            totalTime += travel[idx];
            if (garbage[i].contains("M"))  mTime = totalTime;
            if (garbage[i].contains("P"))  pTime = totalTime;
            if (garbage[i].contains("G"))  gTime = totalTime;
            idx++;
        }
        return  totalGarbage + mTime + pTime + gTime;
    }
}
