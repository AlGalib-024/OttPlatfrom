package csc213.ottplatfrom.rajmee;

/**
 * Series *-- Episode (composition in the UML diagram: an episode cannot
 * exist without its parent series).
 */
public class Episode {

    private final int episodeId;
    private final String title;
    private final int episodeNumber;
    private final String videoFile;

    public Episode(int episodeId, String title, int episodeNumber, String videoFile) {
        this.episodeId = episodeId;
        this.title = title;
        this.episodeNumber = episodeNumber;
        this.videoFile = videoFile;
    }

    public int getEpisodeId() { return episodeId; }
    public String getTitle() { return title; }
    public int getEpisodeNumber() { return episodeNumber; }
    public String getVideoFile() { return videoFile; }

    @Override
    public String toString() { return "Ep " + episodeNumber + ": " + title; }
}
