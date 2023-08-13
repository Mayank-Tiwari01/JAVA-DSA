package ArrayQuestions;
import java.util.Arrays;

public class Image {
    public static void main(String[] args) {
       int[][] image ={
         {1,1,0},
         {1,0,1},
        {0,0,1}

       };

       int length = image.length;

       int rev = 0;
       int[][] revImage = new int[length][length];

       for (int row = 0; row < length; row++ ){
        for (int col = image[row].length - 1; col >= 0; col--){
            revImage[row][rev] = image[row][col];
            rev++;
            
        }
        rev = 0;
       

    }

    for (int row = 0; row < length; row++ ){
        for (int col = 0; col < image[row].length ; col++){
            if(revImage[row][col] == 0){
                revImage[row][col] = 1;
            }
            else if(revImage[row][col] == 1){
               revImage[row][col] = 0;
            }
        }
    }

    for (int[] row : revImage) {
        System.out.println(Arrays.toString(row));
    }

}
}
