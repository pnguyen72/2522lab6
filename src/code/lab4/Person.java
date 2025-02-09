package lab4;

import lab1.Date;

/**
 * Represents a Person with a name, date of birth, and optionally, a date of
 * death.
 * Implements Comparable for comparing people by date of birth,
 * Printable for displaying details, and Reversible for reversing the name.
 *
 * @author Felix Nguyen, Leslie Zhang, Liam Pickrell
 * @version 1.0
 */
public class Person implements Comparable<Person>, Printable, Reversible
{
    private final Date dateOfBirth;
    private final Date dateOfDeath;
    private final Name name;

    /**
     * Constructs a Person with a date of birth, date of death, and name.
     *
     * @param dateOfBirth the date of birth of the person
     * @param dateOfDeath the date of death of the person
     * @param name        the name of the person
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Person(final Date dateOfBirth,
                  final Date dateOfDeath,
                  final Name name)
    {
        if(!validateDateOfBirth(dateOfBirth) ||
           !validateDateOfDeath(dateOfBirth, dateOfDeath) ||
           !validateName(name))
        {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.name        = name;
    }

    /**
     * Constructs a living Person with a date of birth and name.
     * The date of death is set to null.
     *
     * @param dateOfBirth the date of birth of the person
     * @param name        the name of the person
     * @throws IllegalArgumentException if any parameter is invalid
     */
    public Person(final Date dateOfBirth,
                  final Name name)
    {
        if(!validateDateOfBirth(dateOfBirth) ||
           !validateName(name))
        {
            throw new IllegalArgumentException("Invalid Parameters");
        }
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.name        = name;
    }

    /**
     * Validates the date of birth.
     *
     * @param dateOfBirth the date of birth to validate
     * @return true if the date of birth is not null, false otherwise
     */
    private boolean validateDateOfBirth(final Date dateOfBirth)
    {
        if(dateOfBirth == null) {return false;}
        return true;
    }

    /**
     * Validates the name.
     *
     * @param name the name to validate
     * @return true if the name is not null, false otherwise
     */
    private boolean validateName(final Name name)
    {
        if(name == null) {return false;}
        return true;
    }

    /**
     * Validates the date of death to ensure it is after the date of birth.
     *
     * @param dateOfBirth the date of birth
     * @param dateOfDeath the date of death
     * @return true if the date of death is after the date of birth, false
     * otherwise
     */
    private boolean validateDateOfDeath(final Date dateOfBirth,
                                        final Date dateOfDeath)
    {
        if(dateOfBirth.compareTo(dateOfDeath) > 0)
        {
            return false;
        }
        return true;
    }

    /**
     * Gets the date of birth of the person.
     *
     * @return the date of birth
     */
    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    /**
     * Gets the date of death of the person.
     *
     * @return the date of death, or null if the person is alive
     */
    public Date getDateOfDeath()
    {
        return dateOfDeath;
    }

    /**
     * Gets the name of the person.
     *
     * @return the name
     */
    public Name getName()
    {
        return name;
    }

    /**
     * Compares this person to another person based on their date of birth.
     *
     * @param person the person to compare to
     * @return a negative integer, zero, or a positive integer as this person
     * is older, same age, or younger than the specified person
     */
    @Override
    public int compareTo(Person person)
    {
        return -this.dateOfBirth.compareTo(person.dateOfBirth);
    }

    /**
     * Displays the person's details.
     */
    @Override
    public void display()
    {
        System.out.println("Name: " + name);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Date of Death: " + dateOfDeath);
    }

    @Override
    public String toString()
    {
        return getName().toString();
    }

    /**
     * Reverses the person's name.
     */
    @Override
    public void backward()
    {
        name.backward();
    }
}
