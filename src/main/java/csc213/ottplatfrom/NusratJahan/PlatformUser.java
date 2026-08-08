package csc213.ottplatfrom.NusratJahan;

public class PlatformUser {
    private String userId;
    private String name;
    private String email;
    private String status;

    public PlatformUser(String userId, String name, String email, String status) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.status = status;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String toLine() { return userId + "|" + name + "|" + email + "|" + status; }
}
