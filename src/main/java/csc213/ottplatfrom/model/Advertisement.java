package csc213.ottplatfrom.model;

public class Advertisement {

    private String advertisementId;
    private String advertiserId;
    private String advertisementTitle;
    private String category;
    private String targetAudience;
    private double budget;
    private String startDate;
    private String endDate;
    private String advertisementStatus;

    public Advertisement() {
    }

    public Advertisement(String advertisementId,
                         String advertiserId,
                         String advertisementTitle,
                         String category,
                         String targetAudience,
                         double budget,
                         String startDate,
                         String endDate,
                         String advertisementStatus) {

        this.advertisementId = advertisementId;
        this.advertiserId = advertiserId;
        this.advertisementTitle = advertisementTitle;
        this.category = category;
        this.targetAudience = targetAudience;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
        this.advertisementStatus = advertisementStatus;
    }

    public String getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(String advertisementId) {
        this.advertisementId = advertisementId;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertisementTitle() {
        return advertisementTitle;
    }

    public void setAdvertisementTitle(String advertisementTitle) {
        this.advertisementTitle = advertisementTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAdvertisementStatus() {
        return advertisementStatus;
    }

    public void setAdvertisementStatus(String advertisementStatus) {
        this.advertisementStatus = advertisementStatus;
    }

}