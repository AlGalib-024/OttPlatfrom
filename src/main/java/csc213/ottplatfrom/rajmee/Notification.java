package csc213.ottplatfrom.rajmee;

public class Notification {
    private int notificationId;
    private String title;
    private String message;
    private String notificationType;

    public boolean validateNotification() {
        return true;
    }

    public String previewNotification() {
        return "";
    }

    public boolean sendNotification() {
        return true;
    }
}
