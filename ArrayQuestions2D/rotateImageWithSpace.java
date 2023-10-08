package ArrayQuestions2D;
public class rotateImageWithSpace {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
        };
        swap(matrix);
        int len = matrix.length;
        for (int row = 0; row < len; row++) {
            for (int col = 0; col <matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    static void swap(int[][] matrix) {
        int len = matrix.length;
        int[][] temp = new int[len][len];

        for (int row = 0; row < len; row++) {
            for (int col = 0; col <matrix[row].length; col++) {
               temp[col][len - 1 - row] = matrix[row][col];
            }
        }

        for (int row = 0; row < len; row++) {
            for (int col = 0; col <matrix[row].length; col++) {
                matrix[row][col] = temp[row][col];
            }
        }
    }
}

//the most horrible peace of code ever written.
//public class rotateImage {
//    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9},
//        };
//        swap(matrix);
//        int len = matrix.length;
//        for (int row = 0; row < len; row++) {
//            for (int col = 0; col <matrix[row].length; col++) {
//                System.out.print(matrix[row][col] + " ");
//            }
//            System.out.println();
//        }
//    }
//    static void swap(int[][] matrix) {
//        int len = matrix.length;
//        int[][] temp = new int[len][len];
//
//        for (int row = 0; row < len; row++) {
//            for (int col = 0; col <matrix[row].length; col++) {
//                puttingValues(temp, matrix[row][col]);
//            }
//        }
//
//        for (int row = 0; row < len; row++) {
//            for (int col = 0; col <matrix[row].length; col++) {
//                matrix[row][col] = temp[row][col];
//            }
//        }
//    }
//    static void puttingValues(int[][] temp, int value) {
//        int len = temp.length;
//        for (int col = len - 1; col >= 0; col--) {
//            for (int row = 0; row <temp[col].length; row++) {
//                  temp[row][col] = value;
//                  break;
//            }
//        }
//    }
//}
