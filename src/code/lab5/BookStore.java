package lab5;

import lab6.Literature;

import java.util.*;

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

    private final String                 name;
    private final ArrayList<Novel>       novels;
    private final HashMap<String, Novel> novelMap;

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

        this.name     = name;
        this.novels   = db.getNovels();
        this.novelMap = new HashMap<>();
        for(final Novel novel : novels)
        {
            this.novelMap.put(novel.getTitle(), novel);
        }
    }

    /**
     * Sorts the keys of a given HashMap and returns them as a List.
     *
     * @param map the HashMap containing the keys to be sorted
     * @return a List of sorted keys
     */
    private List<String> getSortedKeyList(HashMap<String, Novel> map)
    {
        Set<String>  keySet  = map.keySet();
        List<String> keyList = new ArrayList<>(keySet);
        Collections.sort(keyList);
        return keyList;
    }

    public final void displayAllNovels()
    {
        List<String> keyList = getSortedKeyList(novelMap);
        for(final Novel novel : novels)
        {
            System.out.println(novel);
        }
    }

    /**
     * Removes titles from the bookstore that contain a specified keyword.
     *
     * @param keyword the keyword to search for in titles
     */
    public final void removeTitlesWithKeyword(final String keyword)
    {
        List<String> sortedTitles = getSortedKeyList(this.novelMap);
        for(final String sortedTitle : sortedTitles)
        {
            if(sortedTitle.toLowerCase().contains(keyword.toLowerCase()))
            {
                this.novelMap.remove(sortedTitle);
            }
        }
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
                System.out.println(novel.getTitle());
            }
        }
    }

    /**
     * Prints all titles in alphabetical order, A-Z.
     */
    public final void printTitlesInAlphaOrder()
    {
        List<String> sortedTitles = getSortedKeyList(this.novelMap);
        for(final String sortedTitle : sortedTitles)
        {
            System.out.println(sortedTitle);
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
            System.out.println(novel.getTitle());
        }
    }

    /**
     * Finds and prints the longest title in the bookstore.
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

        System.out.println(longestNovelTitle.getTitle());
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
     * Counts the number of books that contain a specified word in their title.
     *
     * @param word the word to search for in titles
     * @return the number of books containing the word in their title
     */
    public final int howManyBooksContain(final String word)
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
     * Calculates the percentage of books published between two specified
     * years, inclusive.
     *
     * @param first the starting year of the range
     * @param last  the ending year of the range
     * @return the percentage of books published between the two years
     */
    public final double whichPercentWrittenBetween(final int first,
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
     * Retrieves the oldest book in the bookstore based on the year published.
     *
     * @return the oldest book in the bookstore
     */
    public final Novel getOldestBook()
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
     * Retrieves a list of books whose titles have a specified length.
     *
     * @param length the length of the titles to search for
     * @return a list of books with titles of the specified length
     */
    public final List<Novel> getBooksThisLength(final int length)
    {
        final List<Novel> booksThisLength;
        booksThisLength = new ArrayList<>();

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
        System.out.println(oldest);

        System.out.println("\nBooks with titles 15 characters long:");
        fifteenCharTitles.forEach(novel -> System.out.println(novel.getTitle()));

        System.out.println("\nBook titles NOT containing \"the\", in alpha order:");
        bookstore.removeTitlesWithKeyword("the");
        bookstore.printTitlesInAlphaOrder();

        System.out.println("\nPrint all novels:");
        bookstore.displayAllNovels();
    }
}