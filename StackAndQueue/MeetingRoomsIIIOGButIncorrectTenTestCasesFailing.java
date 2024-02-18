package StackAndQueue;

import java.util.*;

import static StackAndQueue.MeetingRoomsIIIOptimal.fetch; //copied code thingy

//Can't figure out how to handle when multiple room gets available at the same time.
public class MeetingRoomsIIIOGButIncorrectTenTestCasesFailing {
    public static void main(String[] args) {
        int[][] arr = {{18,19},{3,12},{17,19},{2,13},{7,10}};
        int n = 4;
        System.out.println(roomWithMaxMeeting(arr, n));
    }
    static int roomWithMaxMeeting(int[][] meetings, int n) {
        //pq to store meeting duration based on their end time.
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        int[] rooms = new int[n];
        int i = 0;
        //here key would be the starting time of the meeting, because that is said to be unique in the question,
        //and the value would be the room in which that meeting is taking place.
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] meet : meetings) {
            if (!pq.isEmpty()) {
                long[] peek = pq.peek();
                //wait cond
                if (peek[1] > meet[0] && i == n) {
                    int roomToFree = map.get((int)peek[0]);
                    rooms[roomToFree]++;
                    map.put(meet[0], roomToFree);
                    long newEndTime = peek[1] - meet[0] + meet[1];
                    pq.remove();
                    pq.add(new long[]{meet[0], newEndTime});
                }
                //you have rooms left, so you allocate them
                else if (peek[1] > meet[0] && i != n) {
                    rooms[i]++;//go to the next room and increase its value.
                    pq.add(new long[]{meet[0], meet[1]});
                    map.put(meet[0], i);
                    i++;
                }
                //some room got vacant
                else if (peek[1] < meet[0]) {
                    int roomToFree = map.get((int)peek[0]);
                    rooms[roomToFree]++;
                    pq.remove();
                    pq.add(new long[]{meet[0], meet[1]});
                    map.put(meet[0], roomToFree);
                }
            }
            else {
                pq.add(new long[]{meet[0], meet[1]});
                map.put(meet[0], i);
                rooms[i]++;
                i++;
            }
        }
        return fetch(n, rooms);
    }
}
