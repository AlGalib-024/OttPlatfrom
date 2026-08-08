package csc213.ottplatfrom.NusratJahan;

public class SubscriberProfile {
    private String subscriberId;
    private String name;
    private String email;
    private String phone;
    private String country;
    private String planName;
    private String expiryDate;

    public SubscriberProfile(String subscriberId, String name, String email, String phone,
                             String country, String planName, String expiryDate) {
        this.subscriberId = subscriberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.planName = planName;
        this.expiryDate = expiryDate;
    }

    public String getSubscriberId() { return subscriberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getCountry() { return country; }
    public String getPlanName() { return planName; }
    public String getExpiryDate() { return expiryDate; }
}