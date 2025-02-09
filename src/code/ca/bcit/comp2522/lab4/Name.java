package ca.bcit.comp2522.lab4;

/**
 * Represents a bank client's name with formatting methods
 * and validation.
 *
 * @author Felix
 * @version 2
 */
public class Name implements Reversible, Printable
{

    //Constants
    private static final int CHARACTER_LIMIT = 50;
    private static final int FIRST_INDEX     = 0;
    private static final int SECOND_INDEX    = 1;

    private final String firstName;
    private final String lastName;


    /**
     * Checks if firstname and lastname are not null, blank, admin, or exceed
     * character limit.
     *
     * @param firstName first name of account owner
     * @param lastName  last name of account owner
     */
    public Name(final String firstName,
                final String lastName)
    {

        validateFirstName(firstName);
        validateLastName(lastName);

        this.firstName = firstName;
        this.lastName  = lastName;
    }

    /**
     * Getter for first name.
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Getter for last name.
     *
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /*
     * Validates first name if it is not null, blank, the word "admin", and
     * is longer than the character limit.
     * Throws an exception if it one of the options.
     */
    private static void validateFirstName(String firstName)
    {
        if(firstName == null ||
           firstName.isBlank() ||
           firstName.length() >= CHARACTER_LIMIT ||
           firstName.equalsIgnoreCase("admin"))
        {
            throw new IllegalArgumentException("First name is not valid, " +
                                               "please check again");
        }
    }

    /*
     * Validates last name if it is not null, blank, the word "admin", and is
     *  longer than the character limit.
     * Throws an exception if it one of the options.
     */
    private static void validateLastName(String lastName)
    {
        if(lastName == null ||
           lastName.isBlank() ||
           lastName.length() >= CHARACTER_LIMIT ||
           lastName.equalsIgnoreCase("admin"))
        {
            throw new IllegalArgumentException("Last name is not valid, " +
                                               "please check again");
        }
    }

    /**
     * Returns the initials of the first and last names.
     */
    public String getInitials()
    {
        return firstName.substring(FIRST_INDEX, SECOND_INDEX).toUpperCase() +
               "." +
               lastName.substring(FIRST_INDEX, SECOND_INDEX).toUpperCase() +
               ".";
    }

    /**
     * Returns the full name and uppercases
     * the first letter of the first and last name.
     */
    public String getFullName()
    {
        return firstName.substring(FIRST_INDEX, SECOND_INDEX).toUpperCase() +
               firstName.substring(SECOND_INDEX).toLowerCase() +
               " " +
               lastName.substring(FIRST_INDEX, SECOND_INDEX).toUpperCase() +
               lastName.substring(SECOND_INDEX);
    }

    @Override
    public String toString()
    {
        return getFullName();
    }

    /**
     * Prints the name backward.
     */
    public void backward()
    {
        String        fullName;
        StringBuilder fullNameBuilder;
        String        reversedName;

        fullName        = getFullName();
        fullNameBuilder = new StringBuilder(getFullName());
        reversedName    = fullNameBuilder.reverse().toString();

        System.out.println(reversedName);
    }

    @Override
    public void display()
    {
        System.out.println(this.getFullName());
    }
}
