package lab6;

/**
 * Represents a magazine with a title that extends
 * a piece of literature.
 *
 * @author Justin
 * @author Felix
 * @author Armaan
 */
public class Magazine extends Literature
{
    private final String title;

    /**
     * Constructs a magazine with the specified title
     * @param title title of magazine
     */
    Magazine(final String title)
    {
        this.title = title;
    }

    /**
     * Gets the title of the magazine.
     * Overrides abstract method from
     * parent class.
     * @return the title of the magazine.
     */
    @Override
    public String getTitle()
    {
        return title;
    }
}
