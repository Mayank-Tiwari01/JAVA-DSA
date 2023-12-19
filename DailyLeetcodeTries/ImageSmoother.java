package DailyLeetcodeTries;
/*
Everything OG ofc. The idea came when I thought about how the program flow will access the values of the matrix.
From looking at the i and j value of the given point in the main matrix, we can find out its neighbors.
Runtime is 4ms. Beats 94%.
 */
import java.util.*;
public class ImageSmoother {
    public static void main(String[] args) {
        int[][] img = {{100,200,100},{200,50,200},{100,200,100}};
        System.out.println(Arrays.deepToString(smoothImage(img)));
    }
    static int[][] smoothImage(int[][] img) {
        int rows = img.length, cols = img[0].length;
        int[][] smoothImg = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j ++) {
                smoothImg[i][j] = findAvg(i, j, img, rows, cols);
            }
        }
        return smoothImg;
    }

     static int findAvg(int i, int j, int[][]img, int rows, int cols) {
         int[] neighbours = findNeighbours(i, j, rows, cols);
         int ans = 0,  num = 0;

         for (int row = neighbours[0]; row <= neighbours[1]; row++) {
             for (int col = neighbours[2]; col <= neighbours[3]; col++) {
                 ans += img[row][col];
                 num++;
             }
         }
         return (ans / num);
    }
    static int[] findNeighbours(int i, int j, int rows, int cols) {
        int[] neighbours = new int[4];
        //0 = i start, 1 = i end. 2 = j start, 3 = j end;

        //calculate i start and i end.
        if (i == 0) neighbours[0] = 0;

        else neighbours[0] = i - 1;

        if (i < rows - 1)  neighbours[1] = i + 1;

        else if (i == rows - 1) neighbours[1] = i;

        //calculate j start and j end.
        if (j == 0) neighbours[2] = j;

        else  neighbours[2] = j - 1;

        if (j < cols - 1) neighbours[3] = j + 1;

        else if (j == cols - 1) neighbours[3] = j;

        return neighbours;
    }
}
