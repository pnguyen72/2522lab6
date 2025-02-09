import lab4.Author;
import lab4.Book;
import lab5.Database;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Database db = new Database("2522lab5",
                                   "felix",
                                   "0000");

        ArrayList<Book> booksWithTitleMoreThan20Char = db.getBooks(
                "WHERE LENGTH(title) > 20");
        System.out.println("------ Books with title more than 20 char ------");
        for(Book book : booksWithTitleMoreThan20Char)
        {
            System.out.println(book);
        }

        ArrayList<Author> authorsBornBefore1900 = db.getAuthors(
                "WHERE YEAR(dateOfBirth) < 1900");
        System.out.println("\n------ Authors born before 1900 ------");
        for(Author author : authorsBornBefore1900)
        {
            System.out.println(author);
        }
    }
}
