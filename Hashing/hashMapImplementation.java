package Hashing;
import java.util.*;
public class hashMapImplementation {
    public static void main(String[] arguments) {
        int[] arr = {1,1,2,2,2,3,4,5,5,5,5,6,7,2};
        int freqNum = 2;
        int ans = frequency(arr, freqNum);
        if (ans > 0) {
            System.out.println("The Value " + freqNum+ " is appearing " + ans + " time(s)");
        }
        else {
            System.out.println("The value specified does not exist in the array. Please enter a valid number.");
        }
    }
    static int frequency(int[]arr, int freqNum) {
       HashMap<Integer, Integer> freqMap = new HashMap<>(); //key, value (int, int)
        //Map<Integer, Integer> freqMap = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        if (freqMap.containsKey(freqNum)) {
            return freqMap.get(freqNum);
        }
        else {
            return - 1;
        }
        /*
        or you can simply write this as
        return freqMap.getOrDefault(freqNum, -1);
         */
    }
}
/*
.getOrDefault:
It is used to retrieve the value associated with a given key in the map.
If the key is not found in the map, it returns a default value specified by you.
key: The key whose associated value you want to retrieve.
defaultValue: The value to return if the key is not found in the map.
 */