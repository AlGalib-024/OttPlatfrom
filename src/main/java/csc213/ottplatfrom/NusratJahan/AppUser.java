package csc213.ottplatfrom.NusratJahan;

/** Public because the login screen (a different package) needs to read it. */
public class AppUser {
    private String userId;
    private String role;
    private String displayName;

    public AppUser(String userId, String role, String displayName) {
        this.userId = userId;
        this.role = role;
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    public String getDisplayName() {
        return displayName;
    }
}
