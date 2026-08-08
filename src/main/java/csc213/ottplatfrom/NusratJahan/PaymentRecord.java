package csc213.ottplatfrom.NusratJahan;

public class PaymentRecord {
    private String paymentId;
    private String subscriberId;
    private String subscriberName;
    private double amount;
    private String date;
    private String status;
    private String method;

    public PaymentRecord(String paymentId, String subscriberId, String subscriberName,
                         double amount, String date, String status, String method) {
        this.paymentId = paymentId;
        this.subscriberId = subscriberId;
        this.subscriberName = subscriberName;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.method = method;
    }

    public String getPaymentId() { return paymentId; }
    public String getSubscriberId() { return subscriberId; }
    public String getSubscriberName() { return subscriberName; }
    public double getAmount() { return amount; }
    public String getAmountDisplay() { return String.format("$%.2f", amount); }
    public String getDate() { return date; }
    public String getStatus() { return status; }
    public String getMethod() { return method; }
    public void setStatus(String status) { this.status = status; }
    public String toLine() {
        return paymentId + "|" + subscriberId + "|" + subscriberName + "|" + amount + "|" + date + "|" + status + "|" + method;
    }
}