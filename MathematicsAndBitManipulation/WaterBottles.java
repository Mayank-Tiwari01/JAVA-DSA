package MathematicsAndBitManipulation;

public class WaterBottles {
    static int numWaterBottles(int numBottles, int numExchange) {
        int totalDrink = numBottles;
        int div = numBottles / numExchange;
        int rem = numBottles % numExchange;

        while (numBottles >= numExchange) {
            totalDrink += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + numBottles % numExchange;
        }
        return totalDrink;
    }
}
