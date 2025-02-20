package lab6;

import lab4.Book;

import java.util.*;

/**
 * @author Justin
 * @author Felix
 * @author Armaan
 * @version 1
 */
public class BookStore<T extends Literature>
{

    private List<T> items = new ArrayList<>();

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


    public static void main(final String[] args)
    {
        final BookStore<Literature> store;
        store = new BookStore<>();

        store.addItem(new Novel("War and Peace"));
        store.addItem(new ComicBook("Spider-Man"));
        store.addItem(new Magazine("National Geographic"));

        store.printItems(); // Should print titles from different item types
    }
}