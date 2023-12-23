package StringsAndStringBuilder;

import java.util.HashSet;

/*
Nothing OG, did not even try to solve it by my own.
Run time 1ms, 96.48. Always use StringBuilder for String concatenation as it is more optimal.
 */
public class PathCrossing {
    public static void main(String[] args) {
        String s = "NESWW";
        System.out.println(isPathCrossing(s));
    }
    static boolean isPathCrossing(String path) {
        HashSet<String> savePath = new HashSet<>();
        savePath.add("0 0");
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') y++;
            else if (path.charAt(i) == 'W') x--;
            else if (path.charAt(i) == 'E') x++;
            else y--;

            StringBuilder coordinates = new StringBuilder();
            coordinates.append(x).append(" ").append(y);

            if (savePath.contains(coordinates.toString())) {
                return true;
            }

            savePath.add(coordinates.toString());
        }
        return false;
    }
}
