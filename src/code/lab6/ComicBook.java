package lab6;

/**
 * Represents a comic book with a title that
 * extends a piece of literature.
 *
 * @author Justin
 * @author Felix
 * @author Armaan
 * @version 1.0
 */
public class ComicBook extends Literature
{
    private final String title;

    /**
     * Constructs a comic book object with the specified title.
     * @param title title of the comic book.
     */
    public ComicBook (final String title)
    {
        this.title = title;
    }

    /**
     * Gets the title of the comic book.
     * Overrides abstract method getTitle from
     * parent class.
     * @return the title of the comic book
     */
    @Override
    public String getTitle()
    {
        return title;
    }
}
