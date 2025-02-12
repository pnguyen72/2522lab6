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

    public static void main(final String[] args)
    {
        final BookStore   bookstore;
        final Novel       oldest;
        final List<Novel> fifteenCharTitles;
        bookstore = new BookStore("Classic Novels Collection");
        System.out.println("All Titles in UPPERCASE:");
        bookstore.printAllTitles();
        System.out.println("\nBook Titles Containing 'the':");
        bookstore.printBookTitle("the");
        System.out.println("\nAll Titles in Alphabetical Order:");
        bookstore.printTitlesInAlphaOrder();
    }
};