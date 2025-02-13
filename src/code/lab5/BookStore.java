package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contains a list of many novels and
 * methods to manipulate them,
 * to demonstrate how to use Java ArrayList.
 *
 * @author Davi
 * @author Felix
 * @author Angelo
 * @version 1
 */
public class BookStore
{
    private static final int COUNTER_INITIATOR  = 0;
    private static final int PERCENT_MULTIPLIER = 100;
    public static final  int ROUND_TO_TEN       = 10;

    private final String           name;
    private final ArrayList<Novel> novels;

    /**
     * Constructs a Bookstore instance,
     * imports a list of novels from MySQL.
     *
     * @param name the bookstore's name
     */
    public BookStore(final String name)
    {
        final Database db;

        db = new Database(Credentials.getDatabaseName(),
                          Credentials.getUser(),
                          Credentials.getPassword());

        this.name   = name;
        this.novels = db.getNovels();
    }

    /**
     * Prints all titles in UPPERCASE.
     */
    public final void printAllTitles()
    {
        for(final Novel novel : novels)
        {
            System.out.println(novel.getTitle().toUpperCase());
        }
    }

    /**
     * Prints all titles that contain the specified parameter.
     *
     * @param title the title to search
     */
    public final void printBookTitle(final String title)
    {
        for(final Novel novel : novels)
        {
            String thisTitle;
            String target;

            thisTitle = novel.getTitle().toLowerCase();
            target    = title.toLowerCase();

            if(thisTitle.contains(target))
            {
                System.out.println(novel);
            }
        }
    }

    /**
     * Prints all titles in alphabetical order, A-Z.
     */
    public final void printTitlesInAlphaOrder()
    {
        ArrayList<Novel> sortedNovels;
        sortedNovels = novels;

        Collections.sort(sortedNovels);
        for(final Novel novel : sortedNovels)
        {
            System.out.println(novel);
        }
    }

    /**
     * Prints all books published in the specified decade, i.e. 2000s
     *
     * @param decade the specified decade
     */
    public final void printGroupByDecade(final int decade)
    {
        List<Novel> novelsByDecade;
        int         decadeNormalized;

        novelsByDecade   = new ArrayList<>();
        decadeNormalized = decade / ROUND_TO_TEN;

        for(final Novel novel : novels)
        {
            if(novel.getYearPublished() / ROUND_TO_TEN == decadeNormalized)
            {
                novelsByDecade.add(novel);
            }
        }

        for(final Novel novel : novelsByDecade)
        {
            System.out.println(novel);
        }
    }

    /**
     * Finds the longest title in the bookstore.
     */
    public final void getLongest()
    {
        Novel longestNovelTitle;
        longestNovelTitle = novels.getFirst();

        for(final Novel novel : novels)
        {
            if(novel.getTitle().length() > longestNovelTitle.getTitle().length())
            {
                longestNovelTitle = novel;
            }
        }

        System.out.println(longestNovelTitle +
                           " by " + longestNovelTitle.getAuthorName() +
                           ", " + longestNovelTitle.getYearPublished());
    }

    /**
     * Returns if there is a book written in a specified year
     *
     * @param year the year
     * @return true or false
     */
    public final boolean isThereABookWrittenIn(final int year)
    {
        for(final Novel novel : novels)
        {
            if(novel.getYearPublished() == year)
            {
                return true;
            }
        }

        return false;
    }


    /**
     * Counts how many books contain the word (passed as a parameter) in
     * their title.
     *
     * @param word to be searched in titles as a String
     * @return the total Books that contain the word in their titles as an int
     */
    public int howManyBooksContain(final String word)
    {
        int count = COUNTER_INITIATOR;
        for(final Novel novel : novels)
        {
            if(novel.getTitle().toLowerCase().contains(word.toLowerCase()))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets 2 years as parameters and calculates the percentage of books that
     * were written
     * between those two years, inclusive.
     *
     * @param first year of the range inclusive
     * @param last  year of the range inclusive
     * @return the percentage as a double
     */
    public double whichPercentWrittenBetween(final int first,
                                             final int last)
    {
        int count = COUNTER_INITIATOR;
        for(final Novel novel : novels)
        {
            if(novel.getYearPublished() >= first &&
               novel.getYearPublished() <= last)
            {
                count++;
            }
        }
        return ((double) count / novels.size()) * PERCENT_MULTIPLIER;
    }

    /**
     * Returns the oldest book in our book store.
     *
     * @return the oldest book
     */
    public Novel getOldestBook()
    {
        Novel oldestNovel;
        oldestNovel = novels.getFirst();

        for(final Novel novel : novels)
        {
            if(novel.getYearPublished() < oldestNovel.getYearPublished())
            {
                oldestNovel = novel;
            }
        }
        return oldestNovel;
    }

    /**
     * Gets length as a parameter and returns a List of novels which the
     * titles have the same length
     * as this parameter
     *
     * @param length of the titles to be added to the List
     * @return the List of books
     */
    public List<Novel> getBooksThisLength(final int length)
    {
        final List<Novel> booksThisLength;
        booksThisLength = new ArrayList<Novel>();

        for(final Novel novel : novels)
        {
            if(novel.getTitle().length() == length)
            {
                booksThisLength.add(novel);
            }
        }
        return booksThisLength;
    }

    /**
     * Runs the program.
     *
     * @param args unused
     */
    public static void main(final String[] args)
    {
        final BookStore   bookstore;
        final Novel       oldest;
        final List<Novel> fifteenCharTitles;

        bookstore         = new BookStore("Classic Novels Collection");
        oldest            = bookstore.getOldestBook();
        fifteenCharTitles = bookstore.getBooksThisLength(15);

        System.out.println("All Titles in UPPERCASE:");
        bookstore.printAllTitles();

        System.out.println("\nBook Titles Containing 'the':");
        bookstore.printBookTitle("the");

        System.out.println("\nAll Titles in Alphabetical Order:");
        bookstore.printTitlesInAlphaOrder();

        System.out.println("\nBooks from the 2000s:");
        bookstore.printGroupByDecade(2000);

        System.out.println("\nLongest Book Title:");
        bookstore.getLongest();

        System.out.println("\nIs there a book written in 1950?");
        System.out.println(bookstore.isThereABookWrittenIn(1950));

        System.out.println("\nHow many books contain 'heart'?");
        System.out.println(bookstore.howManyBooksContain("heart"));

        System.out.println("\nPercentage of books written between 1940 and " +
                           "1950:");
        System.out.println(bookstore.whichPercentWrittenBetween(1940, 1950) + "%");

        System.out.println("\nOldest book:");
        System.out.println(oldest.getTitle() + " by " + oldest.getAuthorName() + ", " + oldest.getYearPublished());

        System.out.println("\nBooks with titles 15 characters long:");
        fifteenCharTitles.forEach(novel -> System.out.println(novel.getTitle()));
    }
};