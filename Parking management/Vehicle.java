import java.time.LocalDateTime;

public class Vehicle {
    String number;
    LocalDateTime entryTime;
    boolean isMonthlyPass;

    public Vehicle(String number, LocalDateTime entryTime, boolean isMonthlyPass) {
        this.number = number;
        this.entryTime = entryTime;
        this.isMonthlyPass = isMonthlyPass;
    }
}
