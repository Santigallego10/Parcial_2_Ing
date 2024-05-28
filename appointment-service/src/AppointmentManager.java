import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AppointmentManager {
    private List<Appointment> appointments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void scheduleAppointment(String patientName, LocalDateTime dateTime, String doctorName) {
        Appointment appointment = new Appointment(patientName, dateTime, doctorName);
        appointments.add(appointment);
        System.out.println("Cita programada: " + appointment);
    }

    public void cancelAppointment() {
        if (appointments.isEmpty()) {
            System.out.println("No hay citas programadas para cancelar.");
            return;
        }

        System.out.println("Seleccione la cita que desea cancelar:");
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println((i + 1) + ". " + appointments.get(i));
        }

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice < 1 || choice > appointments.size()) {
            System.out.println("Selección no válida.");
        } else {
            Appointment appointment = appointments.get(choice - 1);
            appointment.setStatus("Cancelled");
            System.out.println("Cita cancelada: " + appointment);
        }
    }

    public void rescheduleAppointment(String patientName, LocalDateTime oldDateTime, LocalDateTime newDateTime) {
        Optional<Appointment> appointment = findAppointment(patientName, oldDateTime);
        if (appointment.isPresent()) {
            appointment.get().setDateTime(newDateTime);
            appointment.get().setStatus("Rescheduled");
            System.out.println("Cita reprogramada: " + appointment.get());
        } else {
            System.out.println("Cita no encontrada para reprogramación.");
        }
    }

    private Optional<Appointment> findAppointment(String patientName, LocalDateTime dateTime) {
        return appointments.stream()
                .filter(a -> a.getPatientName().equals(patientName) && a.getDateTime().equals(dateTime))
                .findFirst();
    }

    public void listAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No hay citas programadas.");
        } else {
            appointments.forEach(System.out::println);
        }
    }
}
