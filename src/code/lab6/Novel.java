package lab6;

/**
 * Represents a novel with a title that extends
 * a piece of literature.
 *
 * @author Justin
 * @author Felix
 * @author Armaan
 * @version 1.0
 */
public class Novel extends Literature
{
    private final String title;


    /**
     * Constructs a novel with the specified title.
     * @param title title of novel
     */
    public Novel(final String title)
    {
        this.title = title;
    }

    /**
     * Gets the title of the novel.
     * Overrides abstract method from
     * parent class.
     * @return the title of the novel.
     */
    @Override
    public String getTitle()
    {
        return title;
    }
}