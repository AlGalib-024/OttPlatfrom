package csc213.ottplatfrom.rajmee;

/** Content <|-- Movie (Generalization in the UML diagram). */
public class Movie extends Content {

    public Movie(int contentId, String title, String description, String releaseDate,
                 int duration, String language, Genre genre, String status) {
        super(contentId, title, description, releaseDate, duration, language, genre, status);
    }

    @Override
    public String getType() { return "Movie"; }
}
