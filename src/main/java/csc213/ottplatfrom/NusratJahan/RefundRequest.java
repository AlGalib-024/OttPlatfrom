package csc213.ottplatfrom.NusratJahan;

public class RefundRequest {
    private String requestId;
    private String subscriberName;
    private double amount;
    private String reason;
    private String status;

    public RefundRequest(String requestId, String subscriberName, double amount, String reason, String status) {
        this.requestId = requestId;
        this.subscriberName = subscriberName;
        this.amount = amount;
        this.reason = reason;
        this.status = status;
    }

    public String getRequestId() { return requestId; }
    public String getSubscriberName() { return subscriberName; }
    public String getAmountDisplay() { return String.format("$%.2f", amount); }
    public String getReason() { return reason; }
    public String getStatus() { return status; }
}