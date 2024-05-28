import java.util.Scanner;

public class IoTMonitoringHandler {
    private Scanner scanner = new Scanner(System.in);
    private IoTMonitoringManager iotMonitoringManager = new IoTMonitoringManager();

    public void handleRequest() {
        while (true) {
            System.out.println("Gestión de Monitoreo de Salud Remoto:");
            System.out.println("1. Registrar dispositivo IoT");
            System.out.println("2. Iniciar monitoreo");
            System.out.println("3. Detener monitoreo");
            System.out.println("4. Volver al menú principal");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    System.out.println("Ingrese el ID del dispositivo IoT:");
                    String deviceId = scanner.nextLine();
                    System.out.println("Ingrese el tipo de dispositivo:");
                    String deviceType = scanner.nextLine();
                    iotMonitoringManager.registerDevice(deviceId, deviceType);
                    break;
                case 2:
                    System.out.println("Ingrese el ID del dispositivo IoT para iniciar el monitoreo:");
                    String deviceIdToStart = scanner.nextLine();
                    iotMonitoringManager.startMonitoring(deviceIdToStart);
                    break;
                case 3:
                    System.out.println("Ingrese el ID del dispositivo IoT para detener el monitoreo:");
                    String deviceIdToStop = scanner.nextLine();
                    iotMonitoringManager.stopMonitoring(deviceIdToStop);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
