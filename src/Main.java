import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainHandler handler = new MainHandler();
        handler.handleRequest();
    }
}

class MainHandler {
    private Scanner scanner = new Scanner(System.in);

    public void handleRequest() {
        while (true) {
            System.out.println("Seleccione un módulo para gestionar:");
            System.out.println("1. Gestión de Citas Médicas");
            System.out.println("2. Historial Médico Electrónico (EHR)");
            System.out.println("3. Monitoreo de Salud Remoto");
            System.out.println("4. Comunicación en Tiempo Real");
            System.out.println("5. Recordatorios de Medicación");
            System.out.println("6. Análisis y Reportes");
            System.out.println("7. Salir");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    AppointmentHandler appointmentHandler = new AppointmentHandler();
                    appointmentHandler.handleRequest();
                    break;
                case 2:
                    EHRHandler ehrHandler = new EHRHandler();
                    ehrHandler.handleRequest();
                    break;
                case 3:
                    IoTMonitoringHandler iotMonitoringHandler = new IoTMonitoringHandler();
                    iotMonitoringHandler.handleRequest();
                    break;
                case 4:
                    CommunicationHandler communicationHandler = new CommunicationHandler();
                    communicationHandler.handleRequest();
                    break;

                case 5:
                    MedicationHandler medicationHandler = new MedicationHandler();
                    medicationHandler.handleRequest();
                    break;
                case 6:
                    ReportHandler reportHandler = new ReportHandler();
                    reportHandler.handleRequest();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
