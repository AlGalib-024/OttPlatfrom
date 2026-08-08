package csc213.ottplatfrom.Rajmee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Content <|-- Series (Generalization), Series *-- Episode (Composition):
 * episodes belong exclusively to their parent series.
 */
public class Series extends Content {

    private final ObservableList<Episode> episodes = FXCollections.observableArrayList();

    public Series(int contentId, String title, String description, String releaseDate,
                  int duration, String language, Genre genre, String status) {
        super(contentId, title, description, releaseDate, duration, language, genre, status);
    }

    @Override
    public String getType() { return "Series"; }

    public void addEpisode(Episode episode) { episodes.add(episode); }
    public ObservableList<Episode> getEpisodes() { return episodes; }
}
