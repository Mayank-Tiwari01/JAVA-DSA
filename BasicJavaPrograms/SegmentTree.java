package BasicJavaPrograms;
//basic ofc
public class SegmentTree {
    private final int[] segmentTree;
    private final int[] nums;
    private final int n;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = {3,5,1,6,2,7,4};
        SegmentTree segmentTree = new SegmentTree(nums);
        int result = segmentTree.query(3, 4);
        System.out.println(result);
    }

    private void buildSegmentTree(int index, int start, int end) {
        if (start == end) {
            segmentTree[index] = nums[start];
        } else {
            int mid = start + (end - start) / 2;
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;

            buildSegmentTree(leftIndex, start, mid);
            buildSegmentTree(rightIndex, mid + 1, end);
            segmentTree[index] = Math.min(segmentTree[leftIndex], segmentTree[rightIndex]);
        }
    }

    public int query(int queryStart, int queryEnd) {
        return query(0, 0, n - 1, queryStart, queryEnd);
    }

    private int query(int index, int start, int end, int queryStart, int queryEnd) {
        if (queryStart > end || queryEnd < start) {
            return Integer.MAX_VALUE; // Out of range
        }

        if (queryStart <= start && queryEnd >= end) {
            return segmentTree[index]; //within the range
        }

        int mid = start + (end - start) / 2;
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        int left = query(leftIndex, start, mid, queryStart, queryEnd);
        int right = query(rightIndex, mid + 1, end, queryStart, queryEnd);

        return Math.min(left, right);
    }
}

