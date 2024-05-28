import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class EHRManager {
    private Map<String, List<String>> medicalRecords = new HashMap<>();
    private Map<String, Map<String, String>> testResults = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);

    public void registerPatient(String patientName) {
        if (!medicalRecords.containsKey(patientName)) {
            medicalRecords.put(patientName, new ArrayList<>());
            testResults.put(patientName, new HashMap<>());
            System.out.println("Paciente registrado exitosamente: " + patientName);
        } else {
            System.out.println("El paciente ya está registrado.");
        }
    }

    public void addMedicalRecord(String patientName, String record) {
        if (medicalRecords.containsKey(patientName)) {
            medicalRecords.get(patientName).add(record);
            System.out.println("Registro médico añadido exitosamente para " + patientName);
        } else {
            System.out.println("El paciente no está registrado.");
        }
    }

    public void viewMedicalHistory(String patientName) {
        if (medicalRecords.containsKey(patientName)) {
            System.out.println("Historial médico de " + patientName + ":");
            List<String> records = medicalRecords.get(patientName);
            for (String record : records) {
                System.out.println("- " + record);
            }
        } else {
            System.out.println("El paciente no está registrado.");
        }
    }

    public void viewTestHistory(String patientName) {
        if (testResults.containsKey(patientName)) {
            System.out.println("Historial de pruebas de " + patientName + ":");
            Map<String, String> results = testResults.get(patientName);
            for (Map.Entry<String, String> entry : results.entrySet()) {
                System.out.println("- Prueba: " + entry.getKey() + ", Resultado: " + entry.getValue());
            }
        } else {
            System.out.println("El paciente no está registrado.");
        }
    }

    public void addTestResult(String patientName, String testName, String result) {
        if (testResults.containsKey(patientName)) {
            testResults.get(patientName).put(testName, result);
            System.out.println("Resultado de prueba añadido exitosamente para " + patientName);
        } else {
            System.out.println("El paciente no está registrado.");
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Añadir registro médico");
            System.out.println("3. Ver historial médico");
            System.out.println("4. Añadir resultado de prueba");
            System.out.println("5. Ver historial de pruebas realizadas");
            System.out.println("6. Volver al menú principal");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patientName = scanner.nextLine();
                    registerPatient(patientName);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patient = scanner.nextLine();
                    System.out.println("Ingrese el registro médico:");
                    String record = scanner.nextLine();
                    addMedicalRecord(patient, record);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patientToView = scanner.nextLine();
                    viewMedicalHistory(patientToView);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patientForTest = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la prueba:");
                    String testName = scanner.nextLine();
                    System.out.println("Ingrese el resultado de la prueba:");
                    String result = scanner.nextLine();
                    addTestResult(patientForTest, testName, result);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patientToViewTest = scanner.nextLine();
                    viewTestHistory(patientToViewTest);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
