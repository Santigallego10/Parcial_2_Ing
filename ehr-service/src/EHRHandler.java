import java.util.Scanner;

public class EHRHandler {
    private Scanner scanner = new Scanner(System.in);
    private EHRManager ehrManager = new EHRManager();

    public void handleRequest() {
        while (true) {
            System.out.println("Gestión de Historia Clínica Electrónica (EHR):");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Añadir registro médico");
            System.out.println("3. Ver historial médico");
            System.out.println("4. Añadir resultado de prueba");
            System.out.println("5. Ver historial de pruebas realizadas");
            System.out.println("6. Volver al menú principal");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patientName = scanner.nextLine();
                    ehrManager.registerPatient(patientName);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patient = scanner.nextLine();
                    System.out.println("Ingrese el registro médico:");
                    String record = scanner.nextLine();
                    ehrManager.addMedicalRecord(patient, record);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patientToView = scanner.nextLine();
                    ehrManager.viewMedicalHistory(patientToView);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patientForTest = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la prueba:");
                    String testName = scanner.nextLine();
                    System.out.println("Ingrese el resultado de la prueba:");
                    String result = scanner.nextLine();
                    ehrManager.addTestResult(patientForTest, testName, result);
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del paciente:");
                    String patientToViewTest = scanner.nextLine();
                    ehrManager.viewTestHistory(patientToViewTest);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
