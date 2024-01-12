package StringsAndStringBuilder;
/*
https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
Everything OG Ofc.
Got the intuition fairly quickly, within like 10 minutes. What I was thinking at first was that I will maintain two
arrays and then check for anagram, and then make the values of the second array 0. And then do it all over again for
the next window, but half-way I realized that sliding window does not work like that, the count of the chars will remain
the same except the first one, because we are moving ahead of it, so just reduce its count by 1, and then move ahead.
I do not think this is a brute force solution, at first because of that "making all values 0" thought I named it brute
force, but it is very optimal O(N * 26) == O(N). And space O(52) == O(1).

some mistakes :
The anagram method array should run for 26 and not txt len :/
Making freq of the char that we passed as 0, instead of reducing it by 1.
Making all values zero in txt array after every window. Would not work if you were using a Sliding Window. Would work
for n^2 code.

Ps: leetcode has two questions similar to this question, it just wants the index instead of count and
a boolean if it has any anagram or not. (Pasted below)
 */
public class CountOccurencesOfAnagramsBrute {
    public static void main(String[] args) {
        String txt = "aabaabaa";
        String pat = "aaba";
        System.out.println(occurences(txt, pat));
    }
    static int occurences(String txt, String pat) {
        int[] txtCount = new int[26];
        int[] patCount = new int[26];
        int txtLen = txt.length(), patLen = pat.length();
        if (txtLen < patLen) return 0;

        for (int i = 0; i < patLen; i++) {
            int idx = pat.charAt(i) - 'a';
            patCount[idx]++;
        }

        int j = 0, count = 0; // start idx
        for (int i = 0; i < txtLen; i++) {
            txtCount[txt.charAt(i) - 'a']++;
            if (i - j + 1 == patLen) {
                boolean isAnagram = isAnagram(patCount, txtCount, patLen, txtLen);
                if (isAnagram) count++;
                txtCount[txt.charAt(j) - 'a']--;
                j++;
            }
            if (j == txtLen - (patLen - 1)) break;
        }
        return count;
    }

     static boolean isAnagram(int[] patCount, int[] txtCount, int patLen, int txtLen) {
        for (int i = 0; i < 26; i++) {
            if (txtCount[i] != patCount[i]) {
                return false;
            }
        }
        return true;
    }
}
/*
q 438
class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
        int[] txtCount = new int[26];
        int[] patCount = new int[26];

        ArrayList<Integer> anagramIdx = new ArrayList<>();

        int txtLen = txt.length(), patLen = pat.length();
        if (txtLen < patLen) return anagramIdx;

        for (int i = 0; i < patLen; i++) {
            int idx = pat.charAt(i) - 'a';
            patCount[idx]++;
        }

        int j = 0; // start idx
        for (int i = 0; i < txtLen; i++) {
            txtCount[txt.charAt(i) - 'a']++;
            if (i - j + 1 == patLen) {
                boolean isAnagram = isAnagram(patCount, txtCount, patLen, txtLen);
                if (isAnagram) anagramIdx.add(j);
                txtCount[txt.charAt(j) - 'a']--;
                j++;
            }
            if (j == txtLen - (patLen - 1)) break;
        }
        return anagramIdx;
    }

     static boolean isAnagram(int[] patCount, int[] txtCount, int patLen, int txtLen) {
        for (int i = 0; i < 26; i++) {
            if (txtCount[i] != patCount[i]) {
                return false;
            }
        }
        return true;
    }
}

 */

/*
q 567
class Solution {
    public boolean checkInclusion(String pat, String txt) {
        int[] txtCount = new int[26];
        int[] patCount = new int[26];

        ArrayList<Integer> anagramIdx = new ArrayList<>();

        int txtLen = txt.length(), patLen = pat.length();
        if (txtLen < patLen) return false;

        for (int i = 0; i < patLen; i++) {
            int idx = pat.charAt(i) - 'a';
            patCount[idx]++;
        }

        int j = 0; // start idx
        for (int i = 0; i < txtLen; i++) {
            txtCount[txt.charAt(i) - 'a']++;
            if (i - j + 1 == patLen) {
                boolean isAnagram = isAnagram(patCount, txtCount, patLen, txtLen);
                if (isAnagram) return true;
                txtCount[txt.charAt(j) - 'a']--;
                j++;
            }
            if (j == txtLen - (patLen - 1)) break;
        }
        return false;
    }

     static boolean isAnagram(int[] patCount, int[] txtCount, int patLen, int txtLen) {
        for (int i = 0; i < 26; i++) {
            if (txtCount[i] != patCount[i]) {
                return false;
            }
        }
        return true;
    }
}

 */