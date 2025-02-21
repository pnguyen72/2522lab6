package lab6;

/**
 * Represents a piece of literature with a title.
 * This abstract class enforces the implementation of the `getTitle()` method in subclasses.
 *
 * @author Justin
 * @author Felix
 * @author Armaan
 * @version 1.0
 */
public abstract class Literature
{
    /**
     * Abstract method to return the title of the
     * child class objects
     * @return title of child class object
     */
    public abstract String getTitle();
}
