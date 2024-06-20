package BS;
import java.util.Arrays;
public class MagneticForceBetweenTwoBalls {
    static int maxDistance(int[] position, int m) {
        // Sort the positions array to make checking distances easier
        Arrays.sort(position);

        // Initialize the binary search range
        int start = 1; // Minimum possible distance
        int end = position[position.length - 1] - position[0]; // Maximum possible distance
        int ans = -1; // To store the result

        // Binary search to find the maximum minimum distance
        while (start <= end) {
            int mid = start + (end - start) / 2; // Midpoint of the current range

            // Check if it's possible to place m balls with at least mid distance
            if (isPos(mid, position, m)) {
                ans = mid; // Update answer
                start = mid + 1; // Try for a larger distance
            } else {
                end = mid - 1; // Try for a smaller distance
            }
        }

        return ans; // Return the maximum minimum distance found
    }

    // Helper function to check if it's possible to place m balls with at least minDist between them
    static boolean isPos(int minDist, int[] position, int m) {
        int lastPlaced = position[0]; // Place the first ball at the first basket
        m--; // One ball placed, so we need to place m-1 more balls

        // Iterate through the remaining baskets
        for (int i = 1; i < position.length; i++) {
            // Check if the current basket can have a ball placed
            if (position[i] - lastPlaced >= minDist) {
                lastPlaced = position[i]; // Place the ball
                m--; // Decrease the count of balls to be placed

                // If all balls are placed, return true
                if (m == 0) return true;
            }
        }

        return false; // Not possible to place all m balls with at least minDist
    }
}
