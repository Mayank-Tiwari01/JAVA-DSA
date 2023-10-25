package Mathematics;

import java.util.Arrays;

public class FlippingImage {
    public static void main(String[] args) {
        int[][] image = {
                {1}
        };
        flipImage(image);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void flipImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < (image[i].length + 1) / 2; j++) {
                int temp = image[i][j] ^ 1;
                image[i][j] = image[i][image[j].length - j - 1] ^ 1;
                image[i][image[j].length - j - 1] = temp;
            }
        }
    }
}
