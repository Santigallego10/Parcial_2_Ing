import java.util.Scanner;

public class CommunicationHandler {
    private Scanner scanner = new Scanner(System.in);
    private CommunicationManager communicationManager = new CommunicationManager();

    public void handleRequest() {
        while (true) {
            System.out.println("Gestión de Comunicación en Tiempo Real:");
            System.out.println("1. Iniciar videoconferencia");
            System.out.println("2. Enviar mensaje de chat");
            System.out.println("3. Enviar notificación push");
            System.out.println("4. Volver al menú principal");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre del primer participante:");
                    String participant1 = scanner.nextLine();
                    System.out.println("Ingrese el nombre del segundo participante:");
                    String participant2 = scanner.nextLine();
                    communicationManager.startVideoConference(participant1, participant2);
                    break;
                case 2:
                    System.out.println("Ingrese su nombre:");
                    String sender = scanner.nextLine();
                    System.out.println("Ingrese el nombre del destinatario:");
                    String receiver = scanner.nextLine();
                    System.out.println("Ingrese el mensaje:");
                    String message = scanner.nextLine();
                    communicationManager.sendChatMessage(sender, receiver, message);
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del destinatario:");
                    String recipient = scanner.nextLine();
                    System.out.println("Ingrese el mensaje de la notificación push:");
                    String pushMessage = scanner.nextLine();
                    communicationManager.sendPushNotification(recipient, pushMessage);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
