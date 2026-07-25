package csc213.ottplatfrom.NusratJahan;

/*
 * Small data-holder classes used by the CEO and Accountant dashboards.
 * They are kept together in one file so the project does not end up with a
 * separate class file for every simple record.
 */

class Subscriber {
    private String id;
    private String name;
    private String email;
    private String status;
    private String joinDate;

    Subscriber(String id, String name, String email, String status, String joinDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.status = status;
        this.joinDate = joinDate;
    }

    String getId() { return id; }
    String getName() { return name; }
    String getEmail() { return email; }
    String getStatus() { return status; }
    void setStatus(String status) { this.status = status; }
    String getJoinDate() { return joinDate; }
}

class ContentItem {
    private String id;
    private String title;
    private String type;
    private String genre;
    private int releaseYear;
    private String status;
    private String featuredLabel;

    ContentItem(String id, String title, String type, String genre, int releaseYear, String status, String featuredLabel) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.status = status;
        this.featuredLabel = featuredLabel;
    }

    String getId() { return id; }
    String getTitle() { return title; }
    String getType() { return type; }
    String getGenre() { return genre; }
    int getReleaseYear() { return releaseYear; }
    String getStatus() { return status; }
    String getFeaturedLabel() { return featuredLabel; }
    void setFeaturedLabel(String featuredLabel) { this.featuredLabel = featuredLabel; }
}

class Plan {
    private String name;
    private double price;

    Plan(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() { return name; }
    double getPrice() { return price; }
    void setPrice(double price) { this.price = price; }
}

class Feedback {
    private String id;
    private String subscriberName;
    private int rating;
    private String comment;

    Feedback(String id, String subscriberName, int rating, String comment) {
        this.id = id;
        this.subscriberName = subscriberName;
        this.rating = rating;
        this.comment = comment;
    }

    String getId() { return id; }
    String getSubscriberName() { return subscriberName; }
    int getRating() { return rating; }
    String getComment() { return comment; }
}

class Announcement {
    private String id;
    private String title;
    private String body;

    Announcement(String id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    String getId() { return id; }
    String getTitle() { return title; }
    String getBody() { return body; }
}

class PaymentRecord {
    private String id;
    private String subscriberId;
    private String subscriberName;
    private double amount;
    private String date;
    private String method;
    private String status;

    PaymentRecord(String id, String subscriberId, String subscriberName, double amount,
                  String date, String method, String status) {
        this.id = id;
        this.subscriberId = subscriberId;
        this.subscriberName = subscriberName;
        this.amount = amount;
        this.date = date;
        this.method = method;
        this.status = status;
    }

    String getId() { return id; }
    String getSubscriberId() { return subscriberId; }
    String getSubscriberName() { return subscriberName; }
    double getAmount() { return amount; }
    String getDate() { return date; }
    String getMethod() { return method; }
    String getStatus() { return status; }
    void setStatus(String status) { this.status = status; }
}

class RefundRequest {
    private String id;
    private String subscriberName;
    private double amount;
    private String reason;
    private String status;

    RefundRequest(String id, String subscriberName, double amount, String reason, String status) {
        this.id = id;
        this.subscriberName = subscriberName;
        this.amount = amount;
        this.reason = reason;
        this.status = status;
    }

    String getId() { return id; }
    String getSubscriberName() { return subscriberName; }
    double getAmount() { return amount; }
    String getReason() { return reason; }
    String getStatus() { return status; }
}
