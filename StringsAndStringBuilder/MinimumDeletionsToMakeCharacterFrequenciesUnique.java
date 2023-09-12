package StringsAndStringBuilder;
/*
Runtime
7ms
Beats 98.85%of users with Java
implementation is 100% mine and logic too, I was sure that this logic would give a unique looking array
but was not sure that it would also produce it with minimum deletions.
 */
import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public static void main(String[] args) {
        String s = "aaabbbcccdde";
        System.out.println(minimumDeletions(s));
    }
    static int minimumDeletions(String s) {
        int deleteCount = 0;
        int[] charArray = new int[26];
        for (int i : s.toCharArray()) {
            int index = i - 'a';
            charArray[index]++;
        }
        Set<Integer> hash_Set = new HashSet<>();

        for (int i : charArray) {
            if (i != 0 && !hash_Set.contains(i)) {
                hash_Set.add(i);
            }
            else if (i != 0 && hash_Set.contains(i)) {
                while (i != 0 && hash_Set.contains(i)) {
                    i--;
                    deleteCount++;
                }
                hash_Set.add(i);
            }
        }
        return deleteCount;
    }
}
