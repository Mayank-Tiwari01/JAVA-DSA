package StackAndQueue;
import java.util.*;
//lc premium question, Everything OG.
//https://www.interviewbit.com/problems/meeting-rooms/
public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] arr = {{0, 30},{5, 10},{15, 20}};
        System.out.println(minMeetingRooms(arr));
    }
    static int minMeetingRooms(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int minRoom = 0;
        for (int[] ints : arr) {
            if (!pq.isEmpty()) {
                if (pq.peek() <= ints[0]) {
                    pq.remove();
                }
                else {
                    minRoom++;
                }
            }
            else {
                minRoom++;
            }
            pq.add(ints[1]);
        }
        return minRoom;
    }
}
