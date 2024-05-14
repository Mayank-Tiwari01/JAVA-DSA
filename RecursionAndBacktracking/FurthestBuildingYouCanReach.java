package RecursionAndBacktracking;
//will give TLE also see a different way of writing recursion in the comments below.
public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] buildings = {2, 3, 19, 3};
        int bricks = 3;
        int ladder = 1;
        System.out.println(maxReach(buildings, bricks, ladder, 0));
    }
    static int maxReach(int[] arr, int bricks, int ladder, int idx) {
        if (idx + 1 == arr.length) {
            return 0;
        }
        int byBricks = 0;
        int byLadder = 0;

        if (arr[idx] >= arr[idx + 1]) {
            return 1 + maxReach(arr, bricks, ladder, idx + 1);
        }
        else {
            if (arr[idx + 1] - arr[idx] <= bricks) {
                byBricks = 1 + maxReach(arr, bricks - (arr[idx + 1] - arr[idx]), ladder, idx + 1);
            }
            if (ladder > 0) {
                byLadder = 1 + maxReach(arr, bricks, ladder - 1, idx + 1);
            }
            return Math.max(byBricks, byLadder);
        }
    }
}

/*
int index1, index2;

public int furthestBuilding(int[] heights, int bricks, int ladders) {
	return helper(heights, bricks, ladders, 0);
}

public int helper(int[] heights, int bricks, int ladders, int i) {
	if(i >= heights.length - 1)
		return i;

	if(heights[i+1] > heights[i]
	  && (ladders == 0 && bricks < (heights[i+1] - heights[i])))
		return i;

	if(heights[i+1] < heights[i])
		return helper(heights, bricks, ladders, i + 1);

	if(ladders > 0)
		index1 = helper(heights, bricks, ladders - 1, i + 1);

	if(bricks > (heights[i+1] - heights[i]))
		index2 = helper(heights, bricks - (heights[i+1] - heights[i]), ladders, i + 1);

	return Math.max(index1, index2);
}
 */