/**
 * Ilkin Hasanov
 * <p>
 * Copyright (c) HASANOV.
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * IKIN HASANOV's response to Homework "Files management", Module 4.
 *
 *   Task:
 *      1. Parse the file logs.txt. Extract to a separate file all the logs.
 *      2. Calculate the total number of logs (lines).
 *      3. Calculate the total number of ERROR logs using String.split
 *      4. Calculate the total number of ERROR logs using Files.lines.
 *      5. Compare two results.
 *
 *
 * @version 1.10
 * @Since 12-04-2021
 * @class
 * @author Ilkin Hasanov
 */
public class Main {

    public static void main(String[] args) throws IOException {

        int amountOfErrors = 0;
        LocalDateTime start, finish;
// 1. Parse the file logs.txt. Extract to a separate file all the logs.
        start = LocalDateTime.now();
        final String[] lines = new String(Files
                .readAllBytes(Paths.get("src\\logs.txt"))).split("\n");

// 2. Calculate the total number of logs (lines).
        System.out.println("Amount of lines are: " + lines.length);

// 3. Calculate the total number of ERROR logs using String.split

        for (String eachLine : lines) {
            if (eachLine.contains("ERROR")) amountOfErrors++;
        }
        finish = LocalDateTime.now();
        final long timeSpentCountingErrorsInArray =
                ChronoUnit.MILLIS.between(start, finish);
        System.out.println("Amount of lines which indicate ERRORS " +
                "in the array are: " + amountOfErrors);

// 4. Calculate the total number of ERROR logs using Files.lines.
        start = LocalDateTime.now();
        System.out.println("Amount of lines which indicate ERRORS in the " +
                "list are: " + Files.lines(Paths.get("src\\logs.txt"))
                .filter(eachLine -> eachLine.contains("ERROR")).count());
        finish = LocalDateTime.now();
        final long timeSpentCountingErrorsInList =
                ChronoUnit.MILLIS.between(start, finish);

// 5. Compare two results.
        System.out.print("------------------------------------------------" +
                "---------------\nCONCLUSION\n----" +
                "-----------------------------------------------------------" +
                "\nFor counting all \"ERROR\"s in the array it takes: " +
                timeSpentCountingErrorsInArray + " milliseconds." +
                "\nFor counting all \"ERROR\"s in the list it takes: " +
                timeSpentCountingErrorsInList + " milliseconds.\n\n" +
                "In conclusion we can say that it is beneficial to use ");
        if (timeSpentCountingErrorsInArray > timeSpentCountingErrorsInList)
            System.out.println("list than array.");
        else {System.out.println("array than list.");}

/*
Result on console:

Amount of lines are: 433387
Amount of lines which indicate ERRORS in the array are: 105
Amount of lines which indicate ERRORS in the list are: 105
---------------------------------------------------------------
CONCLUSION
---------------------------------------------------------------
For counting all "ERROR"s in the array it takes: 1402 milliseconds.
For counting all "ERROR"s in the list it takes: 1031 milliseconds.

In conclusion we can say that it is beneficial to use list than array
*/
    }
}
