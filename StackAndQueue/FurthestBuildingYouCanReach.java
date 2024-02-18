package StackAndQueue;

import java.util.*;

public class FurthestBuildingYouCanReach {
    public static void main(String[] args) {
        int[] buildings = {4,12,2,7,3,18,20,3,19};
        int bricks = 10;
        int ladder = 2;
        System.out.println(maxReach(buildings, bricks, ladder));
    }

    static int maxReach(int[] arr, int bricks, int ladder) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1])
                continue;
            int diff = arr[i + 1] - arr[i];

            if (diff <= bricks) {
                bricks -= diff;
                pq.add(diff);
            }
            else if (ladder > 0) {
                if (!pq.isEmpty()) {
                    int pastMax = pq.peek();

                    if (pastMax > diff) {
                        bricks +=pastMax;
                        pq.remove();
                        pq.add(diff);
                        bricks -= diff;
                    }
                }
                ladder--;
            }
            else {
                break;
            }
        }
        return i;
    }
}