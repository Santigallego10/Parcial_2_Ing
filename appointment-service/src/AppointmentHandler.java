import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class AppointmentHandler {
    private Scanner scanner = new Scanner(System.in);
    private AppointmentManager manager = new AppointmentManager();

    public void handleRequest() {
        while (true) {
            System.out.println("Gestión de Citas Médicas:");
            System.out.println("1. Programar cita");
            System.out.println("2. Cancelar cita");
            System.out.println("3. Reprogramar cita");
            System.out.println("4. Listar citas");
            System.out.println("5. Volver al menú principal");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (option) {
                case 1:
                    scheduleAppointment();
                    break;
                case 2:
                    manager.cancelAppointment();
                    break;
                case 3:
                    rescheduleAppointment();
                    break;
                case 4:
                    manager.listAppointments();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void scheduleAppointment() {
        System.out.println("Ingrese el nombre del paciente:");
        String patientName = scanner.nextLine();

        System.out.println("Ingrese la fecha y hora de la cita (yyyy-MM-dd HH:mm):");
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.println("Ingrese el nombre del doctor:");
        String doctorName = scanner.nextLine();

        manager.scheduleAppointment(patientName, dateTime, doctorName);
    }

    private void rescheduleAppointment() {
        System.out.println("Ingrese el nombre del paciente:");
        String patientName = scanner.nextLine();

        System.out.println("Ingrese la fecha y hora de la cita actual (yyyy-MM-dd HH:mm):");
        LocalDateTime oldDateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        System.out.println("Ingrese la nueva fecha y hora de la cita (yyyy-MM-dd HH:mm):");
        LocalDateTime newDateTime = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        manager.rescheduleAppointment(patientName, oldDateTime, newDateTime);
    }
}
