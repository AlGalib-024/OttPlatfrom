package csc213.ottplatfrom.rajmee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Optional;

/**
 * Acts as the platform's "file system / database" for the simulation.
 * Every controller reads/writes to these same static lists so data
 * persists as you navigate between screens.
 */
public class DataStore {

    public static final ObservableList<Content> contentList = FXCollections.observableArrayList();
    public static final ObservableList<Campaign> campaigns = FXCollections.observableArrayList();
    public static final ObservableList<Promotion> promotions = FXCollections.observableArrayList();
    public static final ObservableList<Notification> notifications = FXCollections.observableArrayList();
    public static final ObservableList<ReportSummary> reportSummaries = FXCollections.observableArrayList();
    public static final ObservableList<Genre> genres = FXCollections.observableArrayList();

    private static int contentIdCounter = 1;
    private static int campaignIdCounter = 1;
    private static int promotionIdCounter = 1;
    private static int notificationIdCounter = 1;
    private static int reportIdCounter = 1;
    private static int genreIdCounter = 1;
    private static int episodeIdCounter = 1;
    private static int subtitleIdCounter = 1;

    static {
        genres.addAll(
                new Genre(nextGenreId(), "Action"),
                new Genre(nextGenreId(), "Drama"),
                new Genre(nextGenreId(), "Comedy"),
                new Genre(nextGenreId(), "Sci-Fi"),
                new Genre(nextGenreId(), "Horror"),
                new Genre(nextGenreId(), "Documentary"),
                new Genre(nextGenreId(), "Romance"),
                new Genre(nextGenreId(), "Thriller")
        );

        contentList.add(new Movie(nextContentId(), "Inception", "A mind-bending heist thriller.",
                "2010-07-16", 148, "English", findGenreByName("Sci-Fi"), "Available"));

        Series breakingBad = new Series(nextContentId(), "Breaking Bad", "A chemistry teacher turns to crime.",
                "2008-01-20", 47, "English", findGenreByName("Drama"), "Available");
        breakingBad.addEpisode(new Episode(nextEpisodeId(), "Pilot", 1, "pilot.mp4"));
        contentList.add(breakingBad);

        contentList.add(new Series(nextContentId(), "The Office", "A mockumentary sitcom.",
                "2005-03-24", 22, "English", findGenreByName("Comedy"), "Available"));

        campaigns.add(new Campaign(nextCampaignId(), "Summer Sale Promo", "Discount push for new subscribers",
                "2026-06-01", "2026-06-30", "Active"));
    }

    public static int nextContentId() { return contentIdCounter++; }
    public static int nextCampaignId() { return campaignIdCounter++; }
    public static int nextPromotionId() { return promotionIdCounter++; }
    public static int nextNotificationId() { return notificationIdCounter++; }
    public static int nextReportId() { return reportIdCounter++; }
    public static int nextGenreId() { return genreIdCounter++; }
    public static int nextEpisodeId() { return episodeIdCounter++; }
    public static int nextSubtitleId() { return subtitleIdCounter++; }

    public static Genre findGenreByName(String name) {
        if (name == null) return null;
        Optional<Genre> match = genres.stream()
                .filter(g -> g.getGenreName().equalsIgnoreCase(name))
                .findFirst();
        return match.orElse(null);
    }

    /** Simple deterministic "view count" simulation, used by Trending Content / Analytics. */
    public static int simulatedViews(int id) {
        return (id * 137) % 5000 + 100;
    }

    /** Simple deterministic rating simulation (1.0 - 5.0), used by Trending Content / Analytics. */
    public static double simulatedRating(int id) {
        return Math.round(((id * 37) % 41 / 10.0 + 1.0) * 10.0) / 10.0;
    }
}
