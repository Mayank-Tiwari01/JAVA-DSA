package RecursionAndBacktracking;
import java.util.*;
//pretty easy once you get the point, two major mistakes I did not spend enough time thinking about i + 1, i - 1
//j + 1 or j - 1, basically where the rat would move, think it properly next time.
//also, you mark the place where you at, not where you going, so vis[i][j] = 1, not i + 1 or j + 1 etc.
//good problem.
//look at the better written code by striver.
public class RatInAMaze {
    public static void main(String[] args) {
        int[][] m = {{1, 1},
                     {1, 1}};

        int n = 2;
        System.out.println((findPath(m, n)));
    }
     static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder ds = new StringBuilder();
        int[][] vis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = 1;
            }
        }
        if (m[0][0] == 1) solve(ans, ds, m, n, 0, 0, vis);
        return ans;
    }
    static void solve(ArrayList<String> ans, StringBuilder ds, int[][] m, int n, int i, int j, int[][] vis) {
        if (i == n - 1 && j == n - 1) {
            ans.add(ds.toString());
            return;
        }
        //to ensure that our answer comes out in lexicographically increasing order, we will follow this sequence :
        // down => left => right => up

        //move down

        if ( i + 1 < n && m[i + 1][j] == 1 && vis[i + 1][j] == 1) {
            ds.append('D');
            vis[i][j] = 0;
            solve(ans, ds, m, n, i + 1, j, vis);
            ds.deleteCharAt(ds.length() - 1);
            vis[i][j] = 1;
        }

        //move left

        if (j - 1 >= 0 && m[i][j - 1] == 1 && vis[i][j - 1] == 1) {
            ds.append('L');
            vis[i][j] = 0;
            solve(ans, ds, m, n, i, j - 1, vis);
            ds.deleteCharAt(ds.length() - 1);
            vis[i][j] = 1;
        }

        //move right

        if (j + 1 < n && m[i][j + 1] == 1 && vis[i][j + 1] == 1) {
            ds.append('R');
            vis[i][j] = 0;
            solve(ans, ds, m, n, i, j + 1, vis);
            ds.deleteCharAt(ds.length() - 1);
            vis[i][j] = 1;
        }

        //move up

        if (i - 1 >= 0 && m[i - 1][j] == 1 && vis[i - 1][j] == 1) {
            ds.append('U');
            vis[i][j] = 0;
            solve(ans, ds, m, n, i - 1, j, vis);
            ds.deleteCharAt(ds.length() - 1);
            vis[i][j] = 1;
        }
    }
}
