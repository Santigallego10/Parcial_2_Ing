public class IoTDevice {
    private String deviceId;
    private String deviceType;

    public IoTDevice(String deviceId, String deviceType) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }
}
