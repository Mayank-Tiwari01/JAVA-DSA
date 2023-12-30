package DailyLeetcodeTries;
/*
Everything OG ofc. Came up with the intuition pretty quickly. One more check can be done is to count the number of chars
in every string and add them, if it does not divide with length, then it is not redistributable, if it is divisible then do
the below check; both have the same TC and SC though.
2ms, 97.36.
 */
public class RedistributeCharactersToMakeAllStringsEqual {
    public static void main(String[] args) {
        String[] words = {"abc", "aabc", "bc"};
        System.out.println(makeEqual(words));
    }
    static boolean makeEqual(String[] words) {
        int[] charCount = new int[26];
        int len = words.length;

        for (String s : words) {
            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                charCount[idx]++;
            }
        }

        for (int i : charCount) {
            if (i % len != 0) return false;
        }
        return true;
    }
}
/*
class Solution {
    public boolean makeEqual(String[] words) {
      if (words.length == 1) {
			return true;
		}
		int totalCharCount = 0;
		for (String s : words) {
			totalCharCount += s.length();
		}
		if (totalCharCount % words.length != 0) {
			return false;
		}

		int[] myMap = new int[26];
		for (String s : words) {
			for (char c : s.toCharArray()) {
				myMap[c - 'a']++; // dem tan suat xuat hien, 'b' - 'a' = 1
			}
		}
		for (int i : myMap) {
			if (i % words.length != 0) {
				return false;
			}
		}
		return true;
    }
}
 */