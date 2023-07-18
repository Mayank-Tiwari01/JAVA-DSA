package BS;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'a'};
        char target = 'c';
        int start = 0;
        int end = letters.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

                    if(letters[letters.length - 1] - 96 < target - 96 || letters.length == 1){
            System.out.println(letters[0]);
        }


            if(letters[mid] - 96 <= target - 96 ){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }

        System.out.println(letters[start]);  
    }
}
    
