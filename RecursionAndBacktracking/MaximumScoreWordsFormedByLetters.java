package RecursionAndBacktracking;
import java.util.HashMap;
/*
Everything Og, just took little help from chatGpt and mik.
Did it directly on leetcode. Classic Backtracking problem with some easy other functionalities.
Using a 26-size array is much more optimal, see leetcode solution with a note**.

 */
public class MaximumScoreWordsFormedByLetters {
    public static void main(String[] args) {
        String[] words = {"abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno","abcdefghijklmno"};
        //actually char
        String[] letters = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","a","b","c","d","e","f","g","h","i","j"};
        int[] score = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,0,0,0,0,0,0,0,0,0,0,0};

    }
    static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int len = words.length;
        int[] wordsScore = new int[len];
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : letters) {
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }
        calculateIndividualScore(words, letters, score, map, wordsScore);
        int[] max = new int[2];
        calculateMaxScore(words, map, wordsScore, 0, max);

        return max[0];
    }
    static void calculateIndividualScore(String[] words, char[] letters, int[] score, HashMap<Character, Integer> map, int[] wordsScore) {
        int i = 0;
        HashMap<Character, Integer> saveMap = new HashMap<>(map);

        for (String w : words) {
            HashMap<Character, Integer> currentMap = new HashMap<>(saveMap);
            for (char c : w.toCharArray()) {
                if (currentMap.containsKey(c) && currentMap.get(c) > 0 && score[c - 'a'] > 0) {
                    wordsScore[i] += score[c - 'a'];
                    currentMap.put(c, currentMap.get(c) - 1);
                }
                else {
                    wordsScore[i] = 0;
                    break;
                }
            }
            i++;
        }
    }
    static void calculateMaxScore(String[] words,HashMap<Character, Integer> map, int[] wordsScore, int idx, int[] max) {
        if (idx == words.length) {
            max[0] = Math.max(max[0], max[1]);
            return;
        }

        //pick
        if (wordsScore[idx] > 0 && isPos(words[idx], map)) {
            max[1] += wordsScore[idx];
            //reduce count
            manageCount(words[idx], map, false);
            calculateMaxScore(words, map, wordsScore, idx + 1, max);
            //increase count
            manageCount(words[idx], map, true);
            max[1] -= wordsScore[idx];
        }
        //not pick
        calculateMaxScore(words, map, wordsScore, idx + 1, max);
    }
    static boolean isPos(String word, HashMap<Character, Integer> map) {
        HashMap<Character, Integer> saveMap= new HashMap<>(map);
        for (char c : word.toCharArray()) {
            if (!saveMap.containsKey(c) || saveMap.get(c) <= 0)
                return false;
            saveMap.put(c, saveMap.get(c) - 1);
        }
        return true;
    }
    static void  manageCount(String word, HashMap<Character, Integer> map, boolean inc) {
        int temp = (inc) ? 1 : -1;

        for (char c : word.toCharArray())
            map.put(c, map.get(c) + temp);

    }
}
