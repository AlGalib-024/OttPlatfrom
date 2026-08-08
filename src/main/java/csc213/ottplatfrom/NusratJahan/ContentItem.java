package csc213.ottplatfrom.NusratJahan;

public class ContentItem {
    private String contentId;
    private String title;
    private String type;
    private String genre;
    private String releaseYear;
    private String status;
    private boolean featured;

    public ContentItem(String contentId, String title, String type, String genre,
                       String releaseYear, String status, boolean featured) {
        this.contentId = contentId;
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.status = status;
        this.featured = featured;
    }

    public String getContentId() { return contentId; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getGenre() { return genre; }
    public String getReleaseYear() { return releaseYear; }
    public String getStatus() { return status; }
    public boolean isFeatured() { return featured; }
    public String getFeaturedStatus() { return featured ? "Featured" : "Not Featured"; }
    public void setFeatured(boolean featured) { this.featured = featured; }
    public String toLine() {
        return contentId + "|" + title + "|" + type + "|" + genre + "|" + releaseYear + "|" + status + "|" + featured;
    }
}
