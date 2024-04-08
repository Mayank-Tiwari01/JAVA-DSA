package DailyLeetcodeTries;
import java.util.*;
public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        int[] students = {1,1,0,0};
        int[] sandwiches = {0,1,0,1};
        System.out.println(countStudents(students, sandwiches));
        System.out.println(countStudentsOptimal(students, sandwiches));
    }
    static int countStudents(int[] students, int[] sandwiches) {
        int countZero = 0, countOne = 0;
        Deque<Integer> dq = new LinkedList<>();

        for (int student : students) {
            dq.addLast(student);
            if (student == 0)
                countZero++;
            else
                countOne++;
        }
        int i = 0, len = sandwiches.length;
        while (!dq.isEmpty() && i < len) {
            if ((dq.peek() == 1 && sandwiches[i] == 0 && countZero == 0) || (dq.peek() == 0 && sandwiches[i] == 1 && countOne == 0))
                break;

            if ((dq.peek() == 1 && sandwiches[i] == 0 && countZero > 0) || (dq.peek() == 0 && sandwiches[i] == 1 && countOne > 0))
                dq.addLast(dq.poll());

            else if (dq.peek() == 1 && sandwiches[i] == 1) {
                i++;
                dq.poll();
                countOne--;
            }
            else if (dq.peek() == 0 && sandwiches[i] == 0) {
                i++;
                dq.poll();
                countZero--;
            }
        }
        return countZero + countOne;
    }
    static int countStudentsOptimal(int[] students, int[] sandwiches) {
        int countZero = 0, countOne = 0;
        for (int student : students) {
            if (student == 0)
                countZero++;
            else
                countOne++;
        }

        for (int sandwich : sandwiches) {
            if (sandwich == 0 && countZero > 0)
                countZero--;
            else if (sandwich == 1 && countOne > 0)
                countOne--;
            else if ((sandwich == 0 && countZero == 0) || (sandwich == 1 && countOne == 0))
                return countZero + countOne;
        }
        return countZero + countOne;
    }
}
