package StackAndQueue;
import java.util.*;
//T.C : O(m log m +m*n)
public class MeetingRoomsIIIBruteForce {
    public static void main(String[] args) {
        int[][] arr ={{1,10},{2,10},{3,10},{4,10},{5,10},{6,10},{7,10}};
        int n = 2;
        System.out.println(roomWithMaxMeetings(arr, n));
    }
    static int roomWithMaxMeetings(int[][] meetings, int n) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int[] rooms = new int[n];
        long[] meetEndTime = new long[n];

        for (int[] meet : meetings) {

            boolean found = false;
            long min = Long.MAX_VALUE;
            int waitRoomFound = -1;

            for (int i = 0; i < n; i++) {
                if (meetEndTime[i] <= meet[0]) {
                    found = true;
                    meetEndTime[i] = meet[1];
                    rooms[i]++;
                    break;
                }
                if (meetEndTime[i] < min) {
                    min = meetEndTime[i];
                    waitRoomFound = i;
                }
            }
            if (!found) {
                meetEndTime[waitRoomFound] += (meet[1] - meet[0]);
                rooms[waitRoomFound]++;
            }
        }
        int minIdx = -1;
        int maxUsedRoom = Integer.MIN_VALUE;

        for (int j = 0; j < n; j++) {
            if (maxUsedRoom < rooms[j]) {
                maxUsedRoom = rooms[j];
                minIdx = j;
            }
        }
        return minIdx;
    }
}
