package StackAndQueue;

public class CrawlerLogFolder {
    static int minOperations(String[] logs) {
        int count = 0;

        // Iterate through each log entry
        for (String s : logs) {
            // If the log entry is "../" and we are not already in the main folder
            if (s.equals("../")) {
                if (count > 0) {
                    count--; // Move up to the parent folder
                }
            } else if (s.equals("./")) {
                // If the log entry is "./", do nothing (stay in the same folder)
                continue;
            } else {
                // For any other log entry, we move into a child folder
                count++;
            }
        }
        // Return the minimum number of operations to get back to the main folder
        return count;
    }
}
