package csc213.ottplatfrom.model;

public class Subtitle {

    private String subtitleId;
    private String movieTitle;
    private String language;
    private String format;
    private String fileSize;
    private String uploadDate;
    private int downloadCount;

    public Subtitle() {
    }

    public Subtitle(String subtitleId, String movieTitle,
                    String language, String format,
                    String fileSize, String uploadDate,
                    int downloadCount) {

        this.subtitleId = subtitleId;
        this.movieTitle = movieTitle;
        this.language = language;
        this.format = format;
        this.fileSize = fileSize;
        this.uploadDate = uploadDate;
        this.downloadCount = downloadCount;
    }

    public String getSubtitleId() {
        return subtitleId;
    }

    public void setSubtitleId(String subtitleId) {
        this.subtitleId = subtitleId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

}
