package ArrayQuestions;

public class TimeNeededToBuyTickets {
    public static void main(String[] args) {

    }
    static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[k] > tickets[i])
                time += tickets[i];
            else if (tickets[k] < tickets[i] && i < k)
                time += tickets[k];
            else if ((tickets[k] < tickets[i] && i > k) ||
                    (tickets[k] == tickets[i] && i > k))
                time += tickets[k] - 1;
            else if (tickets[k] == tickets[i] && i <= k)
                time += tickets[k];
        }
        return time;
    }
}
