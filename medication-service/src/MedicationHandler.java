import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MedicationHandler {
    private Scanner scanner = new Scanner(System.in);
    private MedicationManager medicationManager = new MedicationManager();

    public void handleRequest() {
        while (true) {
            System.out.println("Gestión de Recordatorios de Medicación:");
            System.out.println("1. Programar recordatorio de medicación");
            System.out.println("2. Cancelar recordatorio de medicación");
            System.out.println("3. Volver al menú principal");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre de la medicación:");
                    String medicationName = scanner.nextLine();
                    System.out.println("Ingrese la hora del recordatorio (formato: yyyy-MM-dd HH:mm):");
                    String reminderTimeString = scanner.nextLine();
                    LocalDateTime reminderTime = LocalDateTime.parse(reminderTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                    medicationManager.scheduleMedicationReminder(medicationName, reminderTime);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la medicación a cancelar:");
                    String medicationToCancel = scanner.nextLine();
                    medicationManager.cancelMedicationReminder(medicationToCancel);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
