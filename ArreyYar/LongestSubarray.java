package ArreyYar;

public class LongestSubarray {
    public static void main(String[] args) {
        int [] a = {1,2,3};
        int k = 3;
        int length = a.length;
        int counter = 0;
        int i = 0;
        int j = 1;
        int sum = 0;

        while (i < j && j <= length - 1){
            sum = a[i] + a[j];
            j++;
            if (sum >= k){
                counter++;
                i++;
            }
        }
        System.out.println(counter);
    }
}
