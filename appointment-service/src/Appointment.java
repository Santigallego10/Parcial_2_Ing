import java.time.LocalDateTime;

public class Appointment {
    private String patientName;
    private LocalDateTime dateTime;
    private String doctorName;
    private String status;  // "Scheduled", "Cancelled", "Rescheduled"

    public Appointment(String patientName, LocalDateTime dateTime, String doctorName) {
        this.patientName = patientName;
        this.dateTime = dateTime;
        this.doctorName = doctorName;
        this.status = "Scheduled";
    }

    // Getters y Setters
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patientName='" + patientName + '\'' +
                ", dateTime=" + dateTime +
                ", doctorName='" + doctorName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
