package BasicJavaPrograms;
//basic ofc
import java.util.*;
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
        int[] nums = {3, 5, 1, 6, 2, 7, 4, 77, 44, 33, 22, 31};
        SegmentTree segmentTree = new SegmentTree(nums);

        int result = segmentTree.query(1, 6);
        System.out.println("Minimum value: " + result);

        segmentTree.updateRange(2, 4, -90);
        System.out.println(Arrays.toString(nums));
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
    public void updateRange(int rangeStart, int rangeEnd, int newValue) {
        if (rangeStart < 0 || rangeEnd >= n || rangeStart > rangeEnd) {
            System.out.println("Invalid range for update");
            return;
        }

        updateRange(0, 0, n - 1, rangeStart, rangeEnd, newValue);
    }

    private void updateRange(int segIndex, int segStart, int segEnd, int rangeStart, int rangeEnd, int newValue) {
        if (segStart > rangeEnd || segEnd < rangeStart) {
            return;
        }

        if (segStart == segEnd) {
            nums[segStart] = newValue;
            segmentTree[segIndex] = newValue;
        } else {
            int mid = segStart + (segEnd - segStart) / 2;
            int leftIndex = 2 * segIndex + 1;
            int rightIndex = 2 * segIndex + 2;

            updateRange(leftIndex, segStart, mid, rangeStart, rangeEnd, newValue);
            updateRange(rightIndex, mid + 1, segEnd, rangeStart, rangeEnd, newValue);

            segmentTree[segIndex] = Math.min(segmentTree[leftIndex], segmentTree[rightIndex]);
        }
    }
}

