import java.time.LocalDateTime;

public class MedicationReminder {
    private String medicationName;
    private LocalDateTime reminderTime;

    public MedicationReminder(String medicationName, LocalDateTime reminderTime) {
        this.medicationName = medicationName;
        this.reminderTime = reminderTime;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }
}
