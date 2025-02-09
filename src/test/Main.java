import lab4.Author;
import lab5.Database;
import lab5.Novel;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Database db = new Database("2522lab5",
                                   "felix",
                                   "0000");

        ArrayList<Novel> novelsTitleMoreThan20Char = db.getNovels(
                "WHERE LENGTH(title) > 20");
        System.out.println("------ Novels with title more than 20 char ------");
        for(Novel novel : novelsTitleMoreThan20Char)
        {
            System.out.println(novel);
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
