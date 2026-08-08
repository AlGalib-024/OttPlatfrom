package csc213.ottplatfrom.Rajmee;

/**
 * Content *-- Subtitle (composition in the UML diagram: a subtitle cannot
 * exist without its parent content).
 */
public class Subtitle {

    private final int subtitleId;
    private final String language;
    private final String format;   // SRT / VTT
    private final String fileName;

    public Subtitle(int subtitleId, String language, String format, String fileName) {
        this.subtitleId = subtitleId;
        this.language = language;
        this.format = format;
        this.fileName = fileName;
    }

    public int getSubtitleId() { return subtitleId; }
    public String getLanguage() { return language; }
    public String getFormat() { return format; }
    public String getFileName() { return fileName; }

    @Override
    public String toString() { return language + " (" + format + ")"; }
}
