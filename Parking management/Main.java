import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot lot = new ParkingLot();

        while (true) {
            System.out.println("\n===  Smart Parking Lot Menu ===");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Exit Vehicle");
            System.out.println("3. Show Status");
            System.out.println("4. Exit App");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    String parkNum = scanner.nextLine().toUpperCase();
                    lot.parkVehicle(parkNum);
                    break;

                case 2:
                    System.out.print("Enter vehicle number to exit: ");
                    String exitNum = scanner.nextLine().toUpperCase();
                    lot.exitVehicle(exitNum);
                    break;

                case 3:
                    lot.showStatus();
                    break;

                case 4:
                    System.out.println(" Exiting application... Thank you!");
                    return;

                default:
                    System.out.println(" Invalid option. Please choose 1–4.");
            }
        }
    }
}
