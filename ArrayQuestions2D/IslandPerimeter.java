package ArrayQuestions2D;

public class IslandPerimeter {
    public static void main(String[] args) {

    }
    static int islandPerimeter(int[][] grid) {
        int result = 0;
        for ( int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1){

                    result += 4;
                    if (i > 0){
                        if (grid[i-1][j] == 1)
                            result -= 2;
                    }
                    if (j > 0){
                        if (grid[i][j-1] == 1)
                            result -= 2;
                    }
                }
            }
        }
        return result;
    }
}
