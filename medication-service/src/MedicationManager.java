import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class MedicationManager {
    private List<MedicationReminder> reminders = new ArrayList<>();
    private Timer timer = new Timer();

    public void scheduleMedicationReminder(String medicationName, LocalDateTime reminderTime) {
        MedicationReminder reminder = new MedicationReminder(medicationName, reminderTime);
        reminders.add(reminder);
        System.out.println("Recordatorio de medicación programado para " + reminderTime + ": " + medicationName);
        scheduleReminderTask(reminder);
    }

    //FUNCION TOMADA DE INTERNET PARA PROBAR LA FUNCIONALIDAD DE UN RECORDATORIO QUE FUNCIONE
    private void scheduleReminderTask(MedicationReminder reminder) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("¡Recordatorio! Es hora de tomar su medicación: " + reminder.getMedicationName());
            }
        }, Date.from(reminder.getReminderTime().atZone(ZoneId.systemDefault()).toInstant()));
    }

    public void cancelMedicationReminder(String medicationName) {
        reminders.removeIf(reminder -> reminder.getMedicationName().equals(medicationName));
        System.out.println("Recordatorio de medicación cancelado: " + medicationName);
    }
}
