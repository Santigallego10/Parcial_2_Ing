import java.util.HashMap;
import java.util.Map;

public class CommunicationManager {
    private Map<String, String> chatMessages = new HashMap<>();
    private Map<String, String> videoConferences = new HashMap<>();
    private Map<String, String> pushNotifications = new HashMap<>();

    public void startVideoConference(String participant1, String participant2) {
        String conferenceId = generateConferenceId();
        videoConferences.put(conferenceId, participant1 + " - " + participant2);
        System.out.println("Videoconferencia iniciada. ID: " + conferenceId);
    }

    public void sendChatMessage(String sender, String receiver, String message) {
        String chatId = sender + "-" + receiver;
        chatMessages.put(chatId, message);
        System.out.println("Mensaje enviado de " + sender + " a " + receiver + ": " + message);
    }

    public void sendPushNotification(String recipient, String message) {
        pushNotifications.put(recipient, message);
        System.out.println("Notificación push enviada a " + recipient + ": " + message);
    }

    private String generateConferenceId() {
        return "CONF_" + System.currentTimeMillis();
    }
}
