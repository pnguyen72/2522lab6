package lab6;

/**
 * Extends Literature,
 * overrides compareTo to use titles alphabetical order,
 * and toString to print all instance data.
 *
 * @author Justin
 * @author Felix
 * @author Armaan
 * @version 1
 */
public class Novel extends Literature
{
    private final String title;


    public Novel(String title)
    {
        this.title = title;
    }

    @Override
    public String getTitle()
    {
        return title;
    }
}