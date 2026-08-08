package csc213.ottplatfrom.model;

public class Subscription {

    private String planId;
    private String planName;
    private double price;
    private String duration;
    private String quality;
    private String description;
    private String status;

    public Subscription() {
    }

    public Subscription(String planId, String planName, double price,
                        String duration, String quality,
                        String description, String status) {

        this.planId = planId;
        this.planName = planName;
        this.price = price;
        this.duration = duration;
        this.quality = quality;
        this.description = description;
        this.status = status;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}