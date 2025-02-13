package lab5;

import lab4.Author;
import lab4.Book;
import lab4.Name;

/**
 * Extends Book from lab 4,
 * overrides compareTo to use titles alphabetical order.
 *
 * @author Felix
 * @author Angelo
 * @author Davi
 * @version 1
 */
public class Novel extends Book
{
    /**
     * Constructs a Novel.
     *
     * @param title         String, the novel's title
     * @param author        Author, the novel's author
     * @param yearPublished int,    the year the novel was published
     */
    public Novel(final String title,
                 final Author author,
                 final int yearPublished)
    {
        super(title, author, yearPublished);
    }

    public String getAuthorName() { return getAuthor().getName().toString(); }

    @Override
    public int compareTo(Book other) { return getTitle().compareTo(other.getTitle()); }
}
