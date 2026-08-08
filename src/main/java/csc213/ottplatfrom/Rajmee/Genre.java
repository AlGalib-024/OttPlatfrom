package csc213.ottplatfrom.Rajmee;

/**
 * Content --> Genre (many-to-one association in the UML diagram).
 */
public class Genre {

    private final int genreId;
    private final String genreName;

    public Genre(int genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public int getGenreId() { return genreId; }
    public String getGenreName() { return genreName; }

    @Override
    public String toString() { return genreName; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        return genreName.equalsIgnoreCase(((Genre) o).genreName);
    }

    @Override
    public int hashCode() { return genreName.toLowerCase().hashCode(); }
}
