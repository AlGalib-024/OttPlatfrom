package csc213.ottplatfrom.Rajmee;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Campaign {

    private final IntegerProperty campaignId;
    private final StringProperty campaignName;
    private final StringProperty description;
    private final StringProperty startDate;
    private final StringProperty endDate;
    private final StringProperty status;

    public Campaign(int campaignId, String campaignName, String description,
                    String startDate, String endDate, String status) {
        this.campaignId = new SimpleIntegerProperty(campaignId);
        this.campaignName = new SimpleStringProperty(campaignName);
        this.description = new SimpleStringProperty(description);
        this.startDate = new SimpleStringProperty(startDate);
        this.endDate = new SimpleStringProperty(endDate);
        this.status = new SimpleStringProperty(status);
    }

    public int getCampaignId() { return campaignId.get(); }
    public String getCampaignName() { return campaignName.get(); }
    public String getDescription() { return description.get(); }
    public String getStartDate() { return startDate.get(); }
    public String getEndDate() { return endDate.get(); }
    public String getStatus() { return status.get(); }

    public void setCampaignName(String v) { this.campaignName.set(v); }
    public void setDescription(String v) { this.description.set(v); }
    public void setStartDate(String v) { this.startDate.set(v); }
    public void setEndDate(String v) { this.endDate.set(v); }
    public void setStatus(String v) { this.status.set(v); }

    public IntegerProperty campaignIdProperty() { return campaignId; }
    public StringProperty campaignNameProperty() { return campaignName; }
    public StringProperty descriptionProperty() { return description; }
    public StringProperty startDateProperty() { return startDate; }
    public StringProperty endDateProperty() { return endDate; }
    public StringProperty statusProperty() { return status; }
}
