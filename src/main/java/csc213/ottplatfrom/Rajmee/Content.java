package csc213.ottplatfrom.Rajmee;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Abstract superclass for Movie and Series (Generalization/Inheritance in
 * the UML diagram). Holds every field common to both content types, plus
 * the composed Subtitle list (Content *-- Subtitle).
 */
public abstract class Content {

    protected final IntegerProperty contentId;
    protected final StringProperty title;
    protected final StringProperty description;
    protected final StringProperty releaseDate; // ISO format, e.g. 2026-07-28
    protected final IntegerProperty duration;   // minutes
    protected final StringProperty language;
    protected final ObjectProperty<Genre> genre;
    protected final StringProperty status;      // Available / Unavailable
    protected final BooleanProperty featured;
    protected final ObservableList<Subtitle> subtitles = FXCollections.observableArrayList();

    protected Content(int contentId, String title, String description, String releaseDate,
                      int duration, String language, Genre genre, String status) {
        this.contentId = new SimpleIntegerProperty(contentId);
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.releaseDate = new SimpleStringProperty(releaseDate);
        this.duration = new SimpleIntegerProperty(duration);
        this.language = new SimpleStringProperty(language);
        this.genre = new SimpleObjectProperty<>(genre);
        this.status = new SimpleStringProperty(status);
        this.featured = new SimpleBooleanProperty(false);
    }

    /** Distinguishes Movie vs Series without needing instanceof everywhere. */
    public abstract String getType();

    public int getContentId() { return contentId.get(); }
    public String getTitle() { return title.get(); }
    public void setTitle(String v) { title.set(v); }
    public String getDescription() { return description.get(); }
    public void setDescription(String v) { description.set(v); }
    public String getReleaseDate() { return releaseDate.get(); }
    public void setReleaseDate(String v) { releaseDate.set(v); }
    public int getDuration() { return duration.get(); }
    public void setDuration(int v) { duration.set(v); }
    public String getLanguage() { return language.get(); }
    public void setLanguage(String v) { language.set(v); }
    public Genre getGenre() { return genre.get(); }
    public void setGenre(Genre v) { genre.set(v); }
    public String getStatus() { return status.get(); }
    public void setStatus(String v) { status.set(v); }
    public boolean isFeatured() { return featured.get(); }
    public void setFeatured(boolean v) { featured.set(v); }

    /** Convenience getter so TableView shows Yes/No instead of true/false. */
    public String getFeaturedLabel() { return featured.get() ? "Yes" : "No"; }

    public ObservableList<Subtitle> getSubtitles() { return subtitles; }
    public void addSubtitle(Subtitle s) { subtitles.add(s); }

    public IntegerProperty contentIdProperty() { return contentId; }
    public StringProperty titleProperty() { return title; }
    public ObjectProperty<Genre> genreProperty() { return genre; }
    public StringProperty statusProperty() { return status; }
    public BooleanProperty featuredProperty() { return featured; }
}
