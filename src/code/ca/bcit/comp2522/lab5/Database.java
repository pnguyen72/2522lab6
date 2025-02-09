package ca.bcit.comp2522.lab5;

import ca.bcit.comp2522.lab1.Date;
import ca.bcit.comp2522.lab4.Author;
import ca.bcit.comp2522.lab4.Book;
import ca.bcit.comp2522.lab4.Name;

import java.sql.*;
import java.util.ArrayList;

/**
 * A library to read data from MySQL, may be helpful for Lab 5.
 * <p>
 * Example usage:
 * <pre>
 * Database db = new Database(YOUR_DB_NAME,   // e.g. "comp2522lab5"
 *                            YOUR_USER_NAME, // e.g. "root"
 *                            YOUR_PASSWORD);
 *
 * ArrayList<Book> allBooks = db.getBooks();
 * ArrayList<Book> booksWithTitleMoreThan20Char = db.getBooks(
 *                            "WHERE LENGTH(title) > 20");
 *
 * ArrayList<Author> allAuthors = db.getAuthors();
 * ArrayList<Author> authorsBornBefore1900 = db.getAuthors(
 *                            "WHERE YEAR(dateOfBirth) < 1900");
 * </pre>
 * <p>
 * This library assumes your database is structured like this:
 * <pre>
 * CREATE TABLE author (
 *      id          INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 *      firstName   VARCHAR(49) NOT NULL,
 *      lastName    VARCHAR(49) NOT NULL,
 *      genre       VARCHAR(29) NOT NULL,
 *      dateOfBirth DATE NOT NULL,
 *      dateOfDeath DATE
 * );
 * CREATE TABLE book (
 *      id            INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 *      title         TEXT NOT NULL,
 *      author        INT NOT NULL,
 *      yearPublished INT NOT NULL,
 *      FOREIGN KEY (author) REFERENCES person(id)
 * );
 * </pre>
 * <p>
 * BY USING THIS SOFTWARE YOU AGREE TO WEAR A HAWAIIAN SHIRT TO THE EXAM.
 *
 * @author felistachio
 * @version 0.0.1
 */
public class Database
{
    private final Connection connection;

    public Database(final String database,
                    final String user,
                    final String password)
    {
        try
        {
            this.connection = DriverManager.getConnection(
                    String.format(
                            "jdbc:mysql://localhost" +
                            "/%s?" +
                            "user=%s&" +
                            "password=%s",
                            database,
                            user,
                            password));
        } catch(final SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * Runs the query {@code SELECT * FROM book;}
     *
     * @return an {@code ArrayList<Book>}
     */
    public ArrayList<Book> getBooks()
    {
        return getBooks("");
    }

    /**
     * Runs the query {@code SELECT * FROM author;}
     *
     * @return an {@code ArrayList<Author>}
     */
    public ArrayList<Author> getAuthors()
    {
        return getAuthors("");
    }

    /**
     * Runs the query {@code SELECT * FROM book [condition];}
     *
     * @param condition a String e.g. "WHERE ..."
     * @return an {@code ArrayList<Book>}
     */
    public ArrayList<Book> getBooks(final String condition)
    {
        final Statement       statement;
        final String          query;
        final ResultSet       resultSet;
        final ArrayList<Book> books;

        query = "SELECT * FROM book " + condition;
        books = new ArrayList<>();

        try
        {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                books.add(getBook(resultSet));
            }
        } catch(final SQLException e)
        {
            throw new RuntimeException(e);
        }

        return books;
    }

    /**
     * Runs the query {@code SELECT * FROM author [condition];}
     *
     * @param condition a String e.g. "WHERE ..."
     * @return an {@code ArrayList<Author>}
     */
    public ArrayList<Author> getAuthors(final String condition)
    {
        final Statement statement;
        final String    query;
        final ResultSet resultSet;

        final ArrayList<Author> authors;

        query = "SELECT *," +
                "YEAR(dateOfBirth) AS birthYear," +
                "MONTH(dateOfBirth) AS birthMonth," +
                "DAY(dateOfBirth) AS birthDay," +
                "YEAR(dateOfDeath) AS deathYear," +
                "MONTH(dateOfDeath) AS deathMonth," +
                "DAY(dateOfDeath) AS deathDay " +
                "FROM author " +
                condition; // e.g. "WHERE ..." (optional)

        authors = new ArrayList<>();

        try
        {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {

                authors.add(getAuthor(resultSet));
            }
        } catch(final SQLException e)
        {
            throw new RuntimeException(e);
        }

        return authors;
    }

    /*
     * Constructs an Author from ID.
     */
    private Author getAuthor(final int id)
    {
        ArrayList<Author> authors;
        authors = getAuthors("WHERE id=" + id);
        if(authors.isEmpty())
        {
            return null;
        }
        return authors.getFirst();
    }

    /*
     * Constructs a Book from an SQL ResultSet.
     */
    private Book getBook(final ResultSet resultSet) throws SQLException
    {
        int    authorId;
        String title;
        Author author;
        int    Published;
        Book   book;

        authorId  = resultSet.getInt("author");
        title     = resultSet.getString("title");
        author    = getAuthor(authorId);
        Published = resultSet.getInt("yearPublished");

        book = new Book(title, author, Published);
        return book;
    }

    /*
     * Constructs an Author from an SQL ResultSet.
     */
    private Author getAuthor(final ResultSet resultSet) throws SQLException
    {
        final Name   name;
        final Date   dateOfBirth;
        final Date   dateOfDeath;
        final String genre;

        name        = new Name(resultSet.getString("firstName"),
                               resultSet.getString("lastName"));
        genre       = resultSet.getString("genre");
        dateOfBirth = new Date(resultSet.getInt("birthDay"),
                               resultSet.getInt("birthMonth"),
                               resultSet.getInt("birthYear"));

        if(resultSet.getDate("dateOfDeath") == null)
        {
            return new Author(dateOfBirth, name, genre);
        }

        dateOfDeath = new Date(resultSet.getInt("deathDay"),
                               resultSet.getInt("deathMonth"),
                               resultSet.getInt("deathYear"));

        return new Author(dateOfBirth, dateOfDeath, name, genre);
    }
}
