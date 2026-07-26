package csc213.ottplatfrom.rajmee;

public class ContentManager extends user {
    private int managerId;
    private String department;

    public Content addContent(Content content) {
        return content;
    }

    public boolean editContent(int contentId) {
        return true;
    }

    public boolean deleteContent(int contentId) {
        return true;
    }

    public boolean uploadSubtitle(Subtitle subtitle) {
        return true;
    }

    public Episode addEpisode(Episode episode) {
        return episode;
    }

    public boolean assignGenre(int contentId, Genre genre) {
        return true;
    }

    public boolean markFeatured(int contentId) {
        return true;
    }

    public Analytics viewAnalytics(int contentId) {
        return new Analytics();
    }
