package DailyLeetcodeTries;

import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOperations {
    public static void main(String[] args) {
        int[] target = {7,10};
        int n = 10; //n is actually redundant and unnecessary for this question.
        System.out.println((buildArray(target)));
    }
    static List<String> buildArray(int[] target) {
        List<String> answer = new ArrayList<>();
        int index = 0;
        for(int i = 1; i <= target[target.length - 1]; i++) {
            if (target[index] == i) {
                answer.add("Push");
                index++;
            }
            else {
                answer.add("Push");
                answer.add("Pop");
            }
        }
        return answer;
    }

}
