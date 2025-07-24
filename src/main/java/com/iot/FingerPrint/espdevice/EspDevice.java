package com.iot.FingerPrint.espdevice;

public class EspDevice {
    private String deviceId;
    private String apiKey;
    private String role;

    public EspDevice(String deviceId, String apiKey, String role) {
        this.deviceId = deviceId;
        this.apiKey = apiKey;
        this.role = role;
    }


    public String getApiKey() {
        return apiKey;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getRole() {
        return role;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
