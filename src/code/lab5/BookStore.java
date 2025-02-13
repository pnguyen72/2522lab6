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
    private final String           name;
    private final ArrayList<Novel> novels;

    public static final int ROUND_TO_TEN = 10;

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
        List<Novel> sortedNovels;
        sortedNovels = novels;

        Collections.sort(sortedNovels);
        for(final Novel novel : sortedNovels)
        {
            System.out.println(novel);
        }
    }

    public final void printGroupByDecade(final int decade)
    {
        List<Novel> novelsByDecade;
        int decadeNormalized;

        novelsByDecade = new ArrayList<>();
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

    public final void getLongest()
    {
        Novel longestNovelTitle;
        longestNovelTitle = novels.getFirst();

        for (final Novel novel : novels)
        {
            if(novel.getTitle().length() > longestNovelTitle.getTitle().length())
            {
                longestNovelTitle = novel;
            }
        }

        System.out.println("Longest Book Title: " + longestNovelTitle.getTitle());
    }

    public final boolean isThereABookWrittenIn(final int year)
    {
        for (final Novel novel : novels)
        {
            if(novel.getYearPublished() == year)
            {
                return true;
            }
        }

        return false;
    }


    public static void main(final String[] args)
    {
        final BookStore   bookstore;
        final Novel       oldest;
        final List<Novel> fifteenCharTitles;

        bookstore = new BookStore("Classic Novels Collection");
        oldest = bookstore.getOldestBook();
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

        System.out.println("\nPercentage of books written between 1940 and 1950:");
        System.out.println(bookstore.whichPercentWrittenBetween(1940, 1950) + "%");

        System.out.println("\nOldest book:");
        System.out.println(oldest.getTitle() + " by " + oldest.getAuthorName() + ", " + oldest.getYearPublished());

        System.out.println("\nBooks with titles 15 characters long:");
        fifteenCharTitles.forEach(novel -> System.out.println(novel.getTitle()));
    }
};