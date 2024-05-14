package RecursionAndBacktracking;
import java.util.*;

//Don't know how accurate is this one, because I could not test it anywhere, gfg has this problem, but the 2d array given
//is in boolean, which is weird, maybe because I have not studied the graph. Anyway, I think it is correct, did it 50% myself.
/*
It is important to note that this approach can be inefficient for large graphs, as it has a worst-case time complexity of O(n!).
For large graphs, other more efficient algorithms, such as the iterative greedy algorithm or the Largest First algorithm,
may be more suitable.

Below is an alternative implementation of the graph coloring problem using the iterative greedy algorithm:
 */
public class MColoringProblem {
    public static void main(String[] args) {
        //edges go from 0 - n.
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int colors = 2;
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);

            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        int nodes = map.size();
        int[] colorMap = new int[nodes];

        System.out.println(graphColoring(0, nodes, colorMap, colors, map));
    }
    static boolean graphColoring(int startNode, int nodes, int[] colorMap, int colors, HashMap<Integer, ArrayList<Integer>> map) {
        if (startNode == nodes)
            return true;

        for (int i = 1; i <= colors; i++) {
            if (isPos(startNode, colorMap, i, map)) {
                colorMap[startNode] = i;
                if (graphColoring(startNode + 1, nodes, colorMap, colors, map))
                    return true;
                else
                    colorMap[startNode] = 0;
            }
        }
        return false;
    }
    static boolean isPos(int startNode, int[] colorMap, int color, HashMap<Integer, ArrayList<Integer>> map) {
        for (int value : map.get(startNode)) {
            if (colorMap[value] == color)
                return false;
        }
        return true;
    }
}
/*
import java.util.ArrayList;
import java.util.HashMap;

public class MColoringProblem {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int colors = 2;
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);

            map.putIfAbsent(edge[1], new ArrayList<>());
            map.get(edge[1]).add(edge[0]);
        }
        int nodes = map.size();
        int[] colorMap = new int[nodes];

        System.out.println(graphColoring(colorMap, colors, map));
    }
    static boolean graphColoring(int[] colorMap, int colors, HashMap<Integer, ArrayList<Integer>> map) {
        for (int node = 0; node < colorMap.length; node++) {
            boolean[] usedColors = new boolean[colors];
            for (int neighbor : map.get(node)) {
                if (colorMap[neighbor] != 0)
                    usedColors[colorMap[neighbor] - 1] = true;
            }
            int color = 1;
            while (color <= colors) {
                if (!usedColors[color - 1]) {
                    colorMap[node] = color;
                    break;
                }
                color++;
            }
            if (color > colors)
                return false;
        }
        return true;
    }
}
 */