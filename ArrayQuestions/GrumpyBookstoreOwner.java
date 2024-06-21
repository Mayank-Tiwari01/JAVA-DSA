package ArrayQuestions;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
    static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //fixed length sliding window.
        int maxPeople = 0, makeSatisfied = -1;
        int j = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                maxPeople += customers[i];
            }
            if (i - j + 1 == minutes) {
                if (maxPeople >= makeSatisfied) {
                    makeSatisfied = maxPeople;
                }
                if (grumpy[j] == 1)
                    maxPeople -= customers[j];
                j++;
            }
        }
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0)
                makeSatisfied += customers[i];
        }
        return makeSatisfied;
    }
}