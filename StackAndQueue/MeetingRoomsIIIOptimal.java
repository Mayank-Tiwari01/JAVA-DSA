package StackAndQueue;

import java.util.*;
//make sure to use long; also, I think the code can be improved.
//when the end time is same, we compare the room number too(smaller room number)
//otherwise the logic is pretty clear.
//https://www.youtube.com/watch?v=8JTr7Hk0p2o
public class MeetingRoomsIIIOptimal {
    public static void main(String[] args) {
        int[][] arr = {{1,10},{2,10},{3,10},{4,10},{5,10},{6,10},{7,10}};
        int n = 2;
        System.out.println(roomWithMaxMeetings(arr, n));
    }
    static int roomWithMaxMeetings(int[][] meetings, int n) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<long[]> endTimes = new PriorityQueue<>(
                Comparator.<long[], Long>comparing(a -> a[1])
                        .thenComparing(a -> a[0])
        );
        PriorityQueue<Integer> avRooms = new PriorityQueue<>();
        int[] rooms = new int [n];

        for (int i = 0; i < n; i++) avRooms.add(i);

        for (int[] meet : meetings) {
            if (!endTimes.isEmpty()) {
                //found a room condition.
                if (endTimes.peek()[1] <= meet[0]) {
                    while (!endTimes.isEmpty() && endTimes.peek()[1] <= meet[0]) {
                        avRooms.add((int) endTimes.peek()[0]);
                        endTimes.remove();
                    }
                    rooms[avRooms.peek()]++;
                    endTimes.add(new long[]{avRooms.poll(), meet[1]});
                }
                //no room got free but there are available rooms, condition.
                else if(endTimes.peek()[1] > meet[0] && !avRooms.isEmpty()) {
                    rooms[avRooms.peek()]++;
                    endTimes.add(new long[]{avRooms.poll(), meet[1]});
                }
                //wait condition
                else if(endTimes.peek()[1] > meet[0] && avRooms.isEmpty()) {
                    long[] temp = endTimes.poll();
                    rooms[(int) temp[0]]++;
                    long newEndTime = temp[1] + (meet[1] - meet[0]);
                    endTimes.add(new long[]{temp[0], newEndTime});
                }
            }
            else {
                if (!avRooms.isEmpty()) {
                    rooms[avRooms.peek()]++;
                    endTimes.add(new long[]{avRooms.poll(), meet[1]});
                }
            }
        }
        return fetch(n, rooms); //returns the index of the room with the highest meetings.
    }

    static int fetch(int n, int[] rooms) {
        int max = Integer.MIN_VALUE;
        int idxMax = -1;
        for (int j = 0; j < n; j++) {
            if (rooms[j] > max) {
                max = rooms[j];
                idxMax = j;
            }
        }
        return idxMax;
    }
}


