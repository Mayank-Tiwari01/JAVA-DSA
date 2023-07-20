package BS;

import java.util.ArrayList;
// galat hai gvar
public class Paliindrome {
    public static void main(String[] args){
        int x = 123;
        ArrayList<Integer> nums = new ArrayList<>();

        while( x != 0){
            nums.add(x % 10);
            x = x / 10;
        }

        int start = 0;
        int end = nums.size() - 1;

        while(start <= end) {
            if(nums.get(start) == nums.get(end)) {
                System.out.println("true");
            }
            start++;
            end--;
        }
    }
}
