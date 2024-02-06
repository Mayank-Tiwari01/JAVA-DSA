package SortingQuestions;
import java.util.*;
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        int i = 0;
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);
            map.putIfAbsent(sortedString, new ArrayList<>());

            map.get(sortedString).add(s);
        }
        ArrayList<List<String>> result = new ArrayList<>();

        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
        //result.addAll(map.values());
        //return new ArrayList<>(map.values()); // much cleaner.
    }

}
