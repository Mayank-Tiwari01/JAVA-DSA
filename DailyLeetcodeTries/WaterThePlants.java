package DailyLeetcodeTries; // it is gfg actually
/*
Nothing OG
The approach as far as I understood is that first you have to see how many taps can reach the first index. Transverse on
all those and see what is their max right reach. Then start your search again from +1 the range that the previous tap
covered. Maintain a target element, at starting it will be 0, and then it becomes whatever is the right max. If your
right max can't even reach the target then return -1. I know I have not understood the question 100%. So please re-visit
it later.
https://www.youtube.com/watch?v=_twHfnNwTwE&list=TLPQMTgwMTIwMjRlAqwbRCwOhQ&index=3
 */
import java.util.*;
public class WaterThePlants {
    public static void main(String[] args) {
        int[] gallery = {-1, 2, 2, -1, 0, 0};
        System.out.println(min_sprinklers(gallery));
    }
    static int min_sprinklers(int[] gallery) {
        ArrayList<List<Integer>> pairs = new ArrayList<List<Integer>>();
        int len = gallery.length;
        for (int i = 0; i < len; i++) {
            if (gallery[i] >= 0) {
                int left = Math.max(0, i - gallery[i]);
                int right = Math.min(len - 1, i + gallery[i]);
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                pairs.add(temp);
                //pairs.add(Arrays.asList(left, right));
            }
        }

        //pairs.sort( (a,b) -> Integer.compare(a.get(0), b.get(0)));
        pairs.sort(Comparator.comparingInt(a -> a.get(0)));
        //sorting with respect to the first element.

        int taps = 0;
        int i = 0;
        int target = 0; // set to zero initially because we want to first transverse on the pairs that cover the first index.
        int size = pairs.size();
        while (target < len) {
            int maxRight = -1;
            while (i < size) {
                if (pairs.get(i).get(0) <= target) {
                    maxRight = Math.max(maxRight, pairs.get(i).get(1));
                    i++;
                }
                else break;
            }

            if (maxRight < target) return -1;
            taps++;
            target = maxRight + 1;
        }
        return taps;
    }
}
