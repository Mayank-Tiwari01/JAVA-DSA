package BS;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 12;
        for(int nums : arr){
            if(nums <= k){
                k++;
            }
//            else{
//                System.out.println(k);
//            }
        }
        System.out.println(k);
    }
}
