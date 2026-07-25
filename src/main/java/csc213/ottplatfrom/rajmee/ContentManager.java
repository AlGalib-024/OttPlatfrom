package csc213.ottplatfrom.rajmee;

import csc213.ottplatfrom.NusratJahan.AppUser;

public class ContentManager extends AppUser {
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
    }}
