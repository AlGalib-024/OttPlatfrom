package csc213.ottplatfrom.rajmee;

public class Content { private int contentId;
    private String title;
    private String contentType;
    private String description;
    private String language;

    public boolean addContent() {
        return true;
    }

    public boolean updateContent(int contentId) {
        return true;
    }

    public boolean deleteContent(int contentId) {
        return true;
    }

    public Content viewDetails(int contentId) {
        return this;
    }
}
