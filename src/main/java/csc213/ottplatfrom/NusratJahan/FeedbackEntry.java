package csc213.ottplatfrom.NusratJahan;

public class FeedbackEntry {
    private String feedbackId;
    private String subscriberName;
    private String rating;
    private String comment;

    public FeedbackEntry(String feedbackId, String subscriberName, String rating, String comment) {
        this.feedbackId = feedbackId;
        this.subscriberName = subscriberName;
        this.rating = rating;
        this.comment = comment;
    }

    public String getFeedbackId() { return feedbackId; }
    public String getSubscriberName() { return subscriberName; }
    public String getRating() { return rating; }
    public String getComment() { return comment; }
}
