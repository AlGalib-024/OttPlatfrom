package csc213.ottplatfrom.NusratJahan;

public class SubscriptionPlan {
    private String planId;
    private String planName;
    private double price;

    public SubscriptionPlan(String planId, String planName, double price) {
        this.planId = planId;
        this.planName = planName;
        this.price = price;
    }

    public String getPlanId() { return planId; }
    public String getPlanName() { return planName; }
    public double getPrice() { return price; }
    public String getPriceDisplay() { return String.format("$%.2f", price); }
    public void setPrice(double price) { this.price = price; }
    public String toLine() { return planId + "|" + planName + "|" + price; }
}
