package DailyLeetcodeTries;
/*
Came with the approach pretty quickly, but implementing it took an hour which is shameful tbh.
I just could not figure out how I get the sum of cost of all the same color balloons.
And then the next problem was when the second pointer reaches the end, and it gives an array out of bound.
11ms, beats 27.51%.
I Need to focus on DSA again as this code is very bad ulti aari bhai.

The approach is we have to remove every similar colored balloon except one, and that one should be the balloon with the
highest cost because we do not want to remove it since we want minimum time to do this task.
So we will keep a variable which will have the max cost, and then we will subtract it with the sum of the
cost of all the similar balloons.
This way we will know the least cost of removing every balloon except one.
 */
public class MinimumTimeToMakeRopeColorfulBadCode {
    public static void main(String[] args) {
        String colors = "aabaa";
        int[] neededTime = {1,2,3,4,1};
        System.out.println(minTime(colors, neededTime));
    }
    static int minTime(String colors, int[] neededTime) {
        int minTime = 0, maxTime = 0, totalTime = 0;
        int first = 0, second = 1;

        while (second < colors.length()) {
            if (colors.charAt(first) == colors.charAt(second)) {
                totalTime += neededTime[second];
                if (neededTime[second] > maxTime ) maxTime = neededTime[second];
                second++;
                if (second == colors.length()) {
                    if (neededTime[first] > maxTime) maxTime = neededTime[first];
                    totalTime += neededTime[first];
                    minTime += totalTime - maxTime;
                    break;
                }
                if (colors.charAt(first) != colors.charAt(second)) {
                    if (neededTime[first] > maxTime) maxTime = neededTime[first];
                    totalTime += neededTime[first];
                    minTime += totalTime - maxTime;
                    first = second;
                    second++;
                    maxTime = 0; totalTime = 0;
                }
            }
            else {
                first++;
                second++;
            }
        }
        return minTime;
    }
}

/*
      for (int i = 0; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i + 1)) {
                totalTime += neededTime[i];
                if (maxTime < neededTime[i]) maxTime = neededTime[i];
                foundRepeating = true;
            }
            else if (foundRepeating && colors.charAt(i) != colors.charAt(i + 1) ||
            foundRepeating && i == colors.length() - 2) {
                totalTime += neededTime[i];
                if (neededTime[i] > maxTime) maxTime = neededTime[i];
                minTime += (totalTime - maxTime);
                totalTime = 0; maxTime = 0;
                foundRepeating = false;
            }
        }
 */
