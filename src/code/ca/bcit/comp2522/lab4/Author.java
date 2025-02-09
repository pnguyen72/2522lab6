package ca.bcit.comp2522.lab4;

import ca.bcit.comp2522.lab1.Date;

/**
 * Represents an Author, extending the Person class with an additional genre
 * attribute.
 * Implements Printable for displaying author details.
 *
 * @author Felix Nguyen, Leslie Zhang, Liam Pickrell
 * @version 1.0
 */
public class Author extends Person implements Printable
{
    private static final int    CHAR_LIMIT = 30;
    private              String genre;

    /**
     * Constructs an Author with a date of birth, date of death, name, and
     * genre.
     *
     * @param dateOfBirth the date of birth of the author
     * @param dateOfDeath the date of death of the author
     * @param name        the name of the author
     * @param genre       the genre the author writes in
     * @throws IllegalArgumentException if the genre is invalid
     */
    public Author(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name,
                  final String genre)
    {

        super(dateOfBirth, dateOfDeath, name);
        if(!validateGenre(genre))
        {
            throw new IllegalArgumentException("Invalid genre");
        }
        this.genre = genre;
    }

    /**
     * Constructs a living Author
     * with a date of birth, date of death, name, and genre.
     * The date of death is set to null.
     *
     * @param dateOfBirth the date of birth of the author
     * @param name        the name of the author
     * @param genre       the genre the author writes in
     * @throws IllegalArgumentException if the genre is invalid
     */
    public Author(final Date dateOfBirth,
                  final Name name,
                  final String genre)
    {

        super(dateOfBirth, name);
        if(!validateGenre(genre))
        {
            throw new IllegalArgumentException("Invalid genre");
        }
        this.genre = genre;
    }

    /**
     * Validates the genre to ensure it is not null, not empty, and does not
     * exceed the character limit.
     *
     * @param genre the genre to validate
     * @return true if the genre is valid, false otherwise
     */
    private boolean validateGenre(final String genre)
    {
        if(genre == null ||
           genre.isEmpty() ||
           genre.length() > CHAR_LIMIT)
        {
            return false;
        }
        return true;
    }

    /**
     * Displays the author's details including name, date of birth, date of
     * death, and genre.
     */
    @Override
    public void display()
    {
        super.display();
        System.out.println("Genre: " + genre);
    }
}
