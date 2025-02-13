package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lab4.*;

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
    private static final int COUNTER_INITIATOR = 0;
    private static final int PERCENT_MULTIPLIER = 100;

    private final String           name;
    private final ArrayList<Novel> novels;

    /**
     * Constructs a Bookstore instance,
     * imports a list of novels from MySQL.
     *
     * @param name String, the bookstore's name
     */
    public BookStore(final String name)
    {
        final Database db;
        db = new Database("2522lab5",
                          "felix",
                          "0000");

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
     * Counts how many books contain the word (passed as a parameter) in their title.
     * @param word to be searched in titles as a String
     * @return the total Books that contain the word in their titles as an int
     */
    public int howManyBooksContain(final String word)
    {
        int count = COUNTER_INITIATOR;
        for(final Novel novel: novels)
        {
            if(novel.getTitle().toLowerCase().contains(word.toLowerCase()))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets 2 years as parameters and calculates the percentage of books that were written
     * between those two years, inclusive.
     * @param first year of the range inclusive
     * @param last year of the range inclusive
     * @return the percentage as a double
     */
    public double whichPercentWrittenBetween(final int first, final int last)
    {
        int count = COUNTER_INITIATOR;
        for(final Novel novel: novels)
        {
            if(novel.getYearPublished() >= first &&
               novel.getYearPublished() <= last)
            {
                count++;
            }
        }
        return ((double) count / novels.size()) * PERCENT_MULTIPLIER;
    }

    public Novel getOldestBook()
    {

    }

    /**
     * Gets length as a parameter and returns a List of novels which the titles has the same length
     * as this parameter
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

    public static void main(final String[] args)
    {
        final BookStore   bookstore;
        final Novel       oldest;
        final List<Novel> fifteenCharTitles;

        BookStore bookstore = new BookStore("Classic Novels Collection");

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
        System.out.println(bookstore.isThereABookWrittenBetween(1950));

        System.out.println("\nHow many books contain 'heart'?");
        System.out.println(bookstore.howManyBooksContain("heart"));

        System.out.println("\nPercentage of books written between 1940 and 1950:");
        System.out.println(bookstore.whichPercentWrittenBetween(1940, 1950) + "%");

        System.out.println("\nOldest book:");
        oldest = bookstore.getOldestBook();
        System.out.println(oldest.getTitle() + " by " + oldest.getAuthorName() + ", " + oldest.getYearPublished());

        System.out.println("\nBooks with titles 15 characters long:");
        fifteenCharTitles = bookstore.getBooksThisLength(15);
        fifteenCharTitles.forEach(novel -> System.out.println(novel.getTitle()));
    }
};