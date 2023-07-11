package ArreyYar;
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
       int[][] revImage = new int[length][];

       for (int row = 0; row < length; row++ ){
        for (int col = image[row].length - 1; col >= 0; col--){
            revImage[row][rev] = image[row][col];
            rev++;
            
        }
        rev = 0;
       

    }

    for (int row = 0; row < length; row++ ){
        for (int col = image[row].length - 1; col >= 0; col--){
            
        }
    }


}
}
