import java.util.Scanner;

public class ReportManager {
    private Scanner scanner = new Scanner(System.in);
    private ReportGenerator reportGenerator = new ReportGenerator();
    private ReportAnalyzer reportAnalyzer = new ReportAnalyzer();

    public void generateHealthReport(String patientName) {
        reportGenerator.generateHealthReport(patientName);
    }

    public void analyzeData() {
        reportAnalyzer.analyzeData();
    }

    public void handleRequest() {
        while (true) {
            System.out.println("Gestión de Análisis y Reportes:");
            System.out.println("1. Generar reporte de salud");
            System.out.println("2. Analizar datos y generar informe de análisis");
            System.out.println("3. Volver al menú principal");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del paciente para generar el reporte de salud:");
                    String patientName = scanner.nextLine();
                    generateHealthReport(patientName);
                    break;
                case 2:
                    analyzeData();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
