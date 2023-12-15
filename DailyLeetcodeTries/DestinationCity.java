package DailyLeetcodeTries;
import java.util.*;
/*
Logic is OG but had to use ChatGPT for implementation. Better solution with 1ms runtime written below.
This solution has a runtime of 3ms.
 */
public class DestinationCity {
    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> path1 = new ArrayList<>();
        path1.add("B");
        path1.add("C");
        paths.add(path1);

        List<String> path2 = new ArrayList<>();
        path2.add("D");
        path2.add("B");
        paths.add(path2);

        List<String> path3 = new ArrayList<>();
        path3.add("C");
        path3.add("A");
        paths.add(path3);

        System.out.println(destCity(paths));
    }
    static String destCity (List<List<String>> paths) {
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            for (int j = 0; j < 2; j++) {
                if (map.containsKey(path.get(j))) {
                    if (j == 0) {
                        map.put(path.get(j), j);
                    }
                    else break;
                }
                else map.put(path.get(j), j);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}
/*
class Solution {
    public String destCity(List<List<String>> paths) {
        if(paths.size()==1)
        return paths.get(0).get(1);

        HashMap<String, String> hm = new HashMap<>();
        for(List<String> path: paths){
        hm.put(path.get(0),path.get(1));
        }

        String destination = paths.get(0).get(0);
        while(hm.containsKey(destination)){
            destination = hm.get(destination);
        }
        return destination;
    }
}
 */
/*
The code first checks if there's only one path in the input. If so, it directly returns the second city of that path, which is the destination city.

It then creates a HashMap (hm) to store the mapping of source cities to destination cities.

The loop iterates through each path in the input list and populates the hashmap with the source city as the key and the destination city as the value.

The initial value of destination is set to the first source city of the first path.

The while loop iterates as long as the current destination city is found in the hashmap. Inside the loop, the destination is updated to the value associated with the current destination city.

The loop continues until a destination city is found that is not a key in the hashmap, indicating that it has no outgoing path.

Finally, the last found destination city is returned.
 */