package lab6;

import java.util.*;

/**
 * @author Justin
 * @author Felix
 * @author Armaan
 * @version 1
 */
public class BookStore<T extends Literature>
{
    static class BookStoreInfo
    {
        public void displayInfo(final String storeName, final int itemCount)
        {
            System.out.println("Book Store: " + storeName + ", Items: " + itemCount);
        }
    }

    private List<T> items = new ArrayList<>();

    class NovelStatistics
    {
        public double averageTitleLength()
        {
            if(items.isEmpty())
            {
                return 0; // Avoid division by zero if list is empty
            }

            int totalLength;
            totalLength = 0;
            for(T item : items)
            {
                totalLength += item.getTitle().length();
            }
            return (double) totalLength / items.size(); // Cast to double
        }

    }

    public void addItem(T item)
    {
        items.add(item);
    }

    public void printItems()
    {
        for(T item : items)
        {
            System.out.println(item.getTitle());
        }
    }

    /**
     * Prints all titles that contain the specified parameter.
     *
     * @param title the title to search
     */
    public final void printBookTitle(final String title)
    {
        if(title.isEmpty())
        {
            return;
        }
        items.forEach(item ->
                      {
                          if(item.getTitle().contains(title))
                          {
                              System.out.println(item.getTitle());
                          }
                      });
    }

    /**
     * Prints all titles in alphabetical order, A-Z.
     */
    public void printTitlesInAlphaOrder()
    {
        // Make a new array of each book's title
        List<String> bookTitles = new ArrayList<>();
        for(T item : items)
        {
            bookTitles.add(item.getTitle());
        }


        bookTitles.sort(String::compareToIgnoreCase);
        bookTitles.forEach(System.out::println);
    }

    public static void main(final String[] args)
    {
        final BookStore<Literature> store;
        store = new BookStore<>();

        store.addItem(new Novel("War and Peace"));
        store.addItem(new ComicBook("Spider-Man"));
        store.addItem(new Magazine("National Geographic"));

        store.printItems(); // Should print titles from different item types

        System.out.println(System.lineSeparator());

        BookStore.BookStoreInfo info = new BookStore.BookStoreInfo();
        info.displayInfo("Chapters", 3);

        System.out.println(System.lineSeparator());

        store.printBookTitle("c");

        System.out.println(System.lineSeparator());

        store.printTitlesInAlphaOrder();
    }
}