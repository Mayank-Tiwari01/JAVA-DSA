package MathematicsAndBitManipulation;
//pretty good problem, read the code and understand yourself.
public class AccountBalanceAfterRoundedPurchase {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(accountBalanceAfterPurchase(n));
    }
    static int accountBalanceAfterPurchase(int purchaseAmount) {
        int toRoundTen = purchaseAmount % 10;
        int rounded = 10 - toRoundTen;

        if (toRoundTen < 5) return 100 - (purchaseAmount - toRoundTen);
        return 100 - (purchaseAmount + rounded);
    }
}