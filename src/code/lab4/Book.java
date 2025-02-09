package lab4;

/**
 * Describes a book object. Contains constructor with
 * Validation methods, getters for all instance variables
 * and overrides the print and compareTo methods.
 *
 * @author Liam Pickrell
 * @author Leslie Zhang
 * @author Felix Nguyen
 * @version 1.0
 */
public class Book implements Comparable<Book>, Printable, Reversible
{

    /*
     * Instance variable declarations.
     */
    private final        String title;
    private final        Author author;
    private final        int    yearPublished;
    private static final int    CURRENT_YEAR             = 2025;
    private static final int    LONGEST_TITLE_CHARACTERS = 100;


    public Book(final String title,
                final Author author,
                final int yearPublished)
    {
        validateTitle(title);
        validateAuthor(author);
        validateYearPublished(yearPublished);

        this.title         = title;
        this.author        = author;
        this.yearPublished = yearPublished;
    }

    /*
     * Validation method for Book's title, used before
     * book objects can be constructed. Title needs to
     * not be null, empty or just whitespace, and needs
     * to have a maximum length of 100 characters.
     *
     * @throws IllegalArgumentException if invalid based
     * on the above parameters.
     */
    private void validateTitle(final String title)
    {
        if(title.length() > LONGEST_TITLE_CHARACTERS ||
           title == null ||
           title.isEmpty() ||
           title.isBlank())
        {
            throw new IllegalArgumentException
                    ("Invalid title: " + title);
        }
    }

    /*
     * Validation method for Book's author, used before
     * book objects can be constructed. Author needs to
     * not be null and needs to successfully be an Author
     * as described in the Author class.
     *
     * @throws IllegalArgumentException if invalid based
     * on the above parameters.
     */
    private void validateAuthor(final Author author)
    {
        if(author == null)
        {
            throw new IllegalArgumentException
                    ("Author is invalid: " + author);
        }
    }

    /*
     * Validation method for Book's yearPublished, used before
     * book objects can be constructed. YearPublished needs to
     * between year 1 and the current year to be valid.
     *
     * @throws IllegalArgumentException if invalid based
     * on the above parameters.
     */
    private void validateYearPublished(final int yearPublished)
    {
        if(yearPublished <= 1 ||
           yearPublished > CURRENT_YEAR)
        {
            throw new IllegalArgumentException
                    ("Year published is invalid: " +
                     yearPublished);
        }
    }

    /**
     * Getter for the book's Title
     *
     * @return title as a String.
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Getter for the book's Author.
     *
     * @return Author as a type Author.
     */
    public Author getAuthor()
    {
        return author;
    }

    /**
     * Getter for the book's Year Published
     *
     * @return the year published as an int.
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    @Override
    public void display()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("Title: ")
          .append(this.getTitle())
          .append("\n");
        sb.append("Year Published: ")
          .append(this.getYearPublished())
          .append("\n");
        sb.append("Author: ")
          .append(this.getAuthor())
          .append("\n");
        System.out.print(sb);
    }

    @Override
    public String toString()
    {
        return title;
    }

    @Override
    public void backward()
    {
        StringBuilder sb = new StringBuilder(title);
        System.out.println(sb.reverse());
    }

    /**
     * Compares two book objects. The older book will be the
     * larger value (CompareTo will return a positive if the
     * book is older than the book we are comparing to).
     *
     * @param b the object to be compared.
     * @return positive if the book we made is older than the
     * book we are comparing to, negative if the book
     * we made is newer than the book we are comparing
     * to, 0 if they are published in the same year.
     */
    @Override
    public int compareTo(Book b)
    {
        return b.yearPublished - yearPublished;
    }
}
