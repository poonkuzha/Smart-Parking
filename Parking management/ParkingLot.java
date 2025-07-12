import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class ParkingLot {
    int capacity = 10;
    Map<String, Vehicle> parked = new HashMap<>();
    Map<String, Integer> visitLog = new HashMap<>();
    List<String> monthlyPass = Arrays.asList("TN01AB1234", "KL07ZZ0001");
    List<String> altLots = Arrays.asList("Lot A (100m)", "Lot B (200m)");

    public boolean parkVehicle(String number) {
        if (parked.size() >= capacity) {
            System.out.println(" Parking Full! Try:");
            for (String lot : altLots) System.out.println(" " + lot);
            return false;
        }

        boolean hasPass = monthlyPass.contains(number);
        Vehicle v = new Vehicle(number, LocalDateTime.now(), hasPass);
        parked.put(number, v);
        visitLog.put(number, visitLog.getOrDefault(number, 0) + 1);

        System.out.println(" Vehicle parked: " + number);
        System.out.println(" Visit count: " + visitLog.get(number));
        return true;
    }

    public double exitVehicle(String number) {
        Vehicle v = parked.remove(number);
        if (v == null) {
            System.out.println(" Vehicle not found in the lot.");
            return -1;
        }

        if (v.isMonthlyPass) {
            System.out.println(" Monthly pass user. No charges.");
            return 0;
        }

        Duration stay = Duration.between(v.entryTime, LocalDateTime.now());
        long hours = Math.max(1, stay.toHours());

        int rate = (LocalTime.now().getHour() >= 22 || LocalTime.now().getHour() < 6) ? 10 : 20;
        double charge = hours * rate;

        // System.out.println(" Duration: " + hours + " hour(s)");
        System.out.println(" Charged :" + charge);
        return charge;
    }

    public int availableSlots() {
        return capacity - parked.size();
    }

    public void showStatus() {
        System.out.println(" Available slots: " + availableSlots());
        if (parked.isEmpty()) {
            System.out.println(" No vehicles currently parked.");
        } else {
            System.out.println(" Parked Vehicles:");
            for (String number : parked.keySet()) {
                System.out.println(" - " + number);
            }
        }
    }
}
