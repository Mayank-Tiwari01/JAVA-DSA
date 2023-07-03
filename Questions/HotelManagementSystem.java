import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelManagementSystem {
    private Map<Integer, String> roomMap;

    public HotelManagementSystem() {
        roomMap = new HashMap<>();
    }

    public void checkIn(int roomNumber, String guestName) {
        roomMap.put(roomNumber, guestName);
        System.out.println("Guest " + guestName + " checked into Room " + roomNumber);
    }

    public void checkOut(int roomNumber) {
        if (roomMap.containsKey(roomNumber)) {
            String guestName = roomMap.remove(roomNumber);
            System.out.println("Guest " + guestName + " checked out from Room " + roomNumber);
        } else {
            System.out.println("Room " + roomNumber + " is currently unoccupied.");
        }
    }

    public void displayGuests() {
        System.out.println("Guest List:");
        for (Map.Entry<Integer, String> entry : roomMap.entrySet()) {
            int roomNumber = entry.getKey();
            String guestName = entry.getValue();
            System.out.println("Room " + roomNumber + ": " + guestName);
        }
    }

    public static void main(String[] args) {
        HotelManagementSystem hotel = new HotelManagementSystem();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Hotel Management System");
            System.out.println("1. Check-in");
            System.out.println("2. Check-out");
            System.out.println("3. Display Guest List");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    hotel.checkIn(roomNumber, guestName);
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    int checkoutRoomNumber = scanner.nextInt();
                    hotel.checkOut(checkoutRoomNumber);
                    break;
                case 3:
                    hotel.displayGuests();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            System.out.println();
        }
        System.out.println("Thank you for using the Hotel Management System!");
    }
}
