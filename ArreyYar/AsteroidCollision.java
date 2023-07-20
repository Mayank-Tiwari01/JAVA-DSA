package ArreyYar;

import java.util.ArrayList;
import java.util.Arrays;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-50, -23, 48, 34, 3, 25, 20, 27, -99};
        int[] ans = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ans));
    }

    static int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                result.add(asteroid);
            } else {
                boolean exploded = false;
                while (!result.isEmpty() && result.get(result.size() - 1) > 0) {
                    if (result.get(result.size() - 1) == Math.abs(asteroid)) {
                        result.remove(result.size() - 1);
                        exploded = true;
                        break;
                    } else if (result.get(result.size() - 1) < Math.abs(asteroid)) {
                        result.remove(result.size() - 1);
                    } else {
                        exploded = true;
                        break;
                    }
                }
                if (!exploded) {
                    result.add(asteroid);
                }
            }
        }

        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }
        return finalResult;
    }
}

