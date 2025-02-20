package lab6;

public class Magazine extends Literature
{
    private final String title;

    Magazine(final String title)
    {
        this.title = title;
    }

    @Override
    public String getTitle()
    {
        return title;
    }
}
