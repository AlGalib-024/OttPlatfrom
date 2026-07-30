package csc213.ottplatfrom.rajmee;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/** MarketingManager *-- Notification (Composition in the UML diagram). */
public class Notification {

    private final IntegerProperty notificationId;
    private final StringProperty title;
    private final StringProperty message;
    private final StringProperty type;           // Promotional / Announcement / Reminder
    private final StringProperty targetAudience;
    private final StringProperty sentDate;

    public Notification(int notificationId, String title, String message, String type,
                        String targetAudience, String sentDate) {
        this.notificationId = new SimpleIntegerProperty(notificationId);
        this.title = new SimpleStringProperty(title);
        this.message = new SimpleStringProperty(message);
        this.type = new SimpleStringProperty(type);
        this.targetAudience = new SimpleStringProperty(targetAudience);
        this.sentDate = new SimpleStringProperty(sentDate);
    }

    public int getNotificationId() { return notificationId.get(); }
    public String getTitle() { return title.get(); }
    public String getMessage() { return message.get(); }
    public String getType() { return type.get(); }
    public String getTargetAudience() { return targetAudience.get(); }
    public String getSentDate() { return sentDate.get(); }

    public IntegerProperty notificationIdProperty() { return notificationId; }
    public StringProperty titleProperty() { return title; }
    public StringProperty typeProperty() { return type; }
    public StringProperty targetAudienceProperty() { return targetAudience; }
    public StringProperty sentDateProperty() { return sentDate; }
}
