package JavaCollections;

import java.util.*;

/**
 * Created by marin on 2/19/16.
 *
 * Write a program to extract all email addresses from given text.
 * The text comes at the first input line.
 * Print the emails in the output, each at a separate line.
 * Emails are considered to be in format <user>@<host>, where:
 *
 * 1) <user> is a sequence of letters and digits,
 * where '.', '-' and '_' can appear between them.
 * Examples of valid users: "stephan", "mike03", "s.johnson", "st_steward", "softuni-bulgaria", "12345".
 * Examples of invalid users: ''--123", ".....", "nakov_-", "_steve", ".info".
 *
 * 2) <host> is a sequence of at least two words, separated by dots '.'.
 * Each word is sequence of letters and can have hyphens '-' between the letters.
 * Examples of hosts: "softuni.bg", "software-university.com", "intoprogramming.info", "mail.softuni.org".
 * Examples of invalid hosts: "helloworld", ".unknown.soft.", "invalid-host-", "invalid-".
 *
 * 3) Example of valid emails: info@softuni-bulgaria.org, kiki@hotmail.co.uk,
 * no-reply@github.com, s.peterson@mail.uu.net, info-bg@software-university.software.academy
 */
public class ExtractEmails {

    public static void main(String[] args) {

        System.out.println("Enter text:");
        Scanner input = new Scanner(System.in);
        String[] words = input.nextLine().split(" ");
        boolean foundEmail = false;

        for (String word :words) {
            // trim special characters positioned directly after the email, e.g. '.'
            word = word.replaceFirst("[\\.+-_\\*]$", "");

            if (word.matches("^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")) {
                System.out.println(word);
                foundEmail = true;
            }

        }

        if (!foundEmail) {
            System.out.println("No email addresses were found!");
        }

    }
}
