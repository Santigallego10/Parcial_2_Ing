import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IoTMonitoringManager {
    private List<IoTDevice> registeredDevices = new ArrayList<>();
    private List<String> monitoringDevices = new ArrayList<>();
    private boolean monitoringStarted = false;
    private Random random = new Random();

    public void registerDevice(String deviceId, String deviceType) {
        IoTDevice device = new IoTDevice(deviceId, deviceType);
        registeredDevices.add(device);
        System.out.println("Dispositivo IoT registrado: " + device.getDeviceType() + " (ID: " + device.getDeviceId() + ")");
    }

    public void startMonitoring(String deviceId) {
        if (!monitoringStarted) {
            monitoringStarted = true;
            monitoringDevices.add(deviceId);
            System.out.println("Monitoreo iniciado para el dispositivo con ID: " + deviceId);
            startMonitoringThread(deviceId);
        } else {
            System.out.println("Ya se ha iniciado el monitoreo.");
        }
    }

    public void stopMonitoring(String deviceId) {
        monitoringDevices.remove(deviceId);
        System.out.println("Monitoreo detenido para el dispositivo con ID: " + deviceId);
        if (monitoringDevices.isEmpty()) {
            monitoringStarted = false;
        }
    }

    private void startMonitoringThread(String deviceId) {
        Thread thread = new Thread(() -> {
            while (monitoringDevices.contains(deviceId)) {
                int measurement = generateRandomMeasurement();
                System.out.println("Medida generada para el dispositivo con ID " + deviceId + ": " + measurement);
                try {
                    Thread.sleep(2000); // Simulación de intervalo de tiempo entre medidas
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private int generateRandomMeasurement() {
        return random.nextInt(61) + 60;
    }
}
