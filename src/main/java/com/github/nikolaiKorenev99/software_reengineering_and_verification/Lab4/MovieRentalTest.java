package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab4;

import org.junit.*;

public class MovieRentalTest extends junit.framework.TestCase {

    Movie theManWhoKnewTooMuch, mulan, slumdogMillionaire;

    @Before
    public void setUp() {
        theManWhoKnewTooMuch = new RegularMovie("The Man Who Knew Too Much");
        mulan = new ChildrenMovie("Mulan");
        slumdogMillionaire = new NewReleaseMovie("Slumdog Millionaire");
    }

    @Test
    public void testGetTitle() {
        assertEquals("The Man Who Knew Too Much", theManWhoKnewTooMuch.get_title());
    }


    @Test
    public void testGetDaysRented() {
        assertEquals(2, new MovieRental(theManWhoKnewTooMuch, 2).getDaysRented());
    }

    @Test
    public void testGetMovie() {
        assertEquals(theManWhoKnewTooMuch, new MovieRental(theManWhoKnewTooMuch, 2).getMovie());
    }

    @Test
    public void testGetName() {
        String name = "John Doe";
        assertEquals(name, new Customer(name)._name);
    }

    @Test
    public void testStatementRegularMovieOnly() {
        // regular movies cost $2.00 for the first 2 days, and $1.50/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoe = new Customer("John Doe");

        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 1));
        assertEquals("Rental Record for " + johnDoe._name + "\n"
                        + "\t" + theManWhoKnewTooMuch.get_title() + "\t" + "2.0"
                        + "\n" + "Amount owed is " + 2.0 + "\n"
                        + "You earned " + 1 + " frequent renter points"
                , johnDoe.statement());

        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 2));
        assertEquals("Rental Record for " + johnDoe._name + "\n"
                        + "\t" + theManWhoKnewTooMuch.get_title() + "\t" + "2.0"
                        + "\n" + "\t" + theManWhoKnewTooMuch.get_title() + "\t" + "2.0"
                        + "\n" + "Amount owed is " + 4.0 + "\n"
                        + "You earned " + 2 + " frequent renter points"
                , johnDoe.statement());

        johnDoe.addMovieRental(new MovieRental(theManWhoKnewTooMuch, 3));
        assertEquals("Rental Record for " + johnDoe._name + "\n"
                        + "\t" + theManWhoKnewTooMuch.get_title() + "\t" + "2.0"
                        + "\n" + "\t" + theManWhoKnewTooMuch.get_title() + "\t" + "2.0"
                        + "\n" + "\t" + theManWhoKnewTooMuch.get_title() + "\t" + "3.5"
                        + "\n" + "Amount owed is " + 7.5 + "\n"
                        + "You earned " + 3 + " frequent renter points"
                , johnDoe.statement());
    }

    @Test
    public void testStatementChildrensMovieOnly() {
        // childrens' movies cost $1.50 for the first 3 days, and $1.25/day thereafter
        // a rental earns 1 frequent-renter point no matter how many days
        Customer johnDoeJr = new Customer("Johnny Doe, Jr.");

        johnDoeJr.addMovieRental(new MovieRental(mulan, 1));
        assertEquals("Rental Record for " + johnDoeJr._name + "\n"
                        + "\t" + mulan.get_title() + "\t" + "1.5"
                        + "\n" + "Amount owed is " + 1.5 + "\n"
                        + "You earned " + 1 + " frequent renter points"
                , johnDoeJr.statement());

        johnDoeJr.addMovieRental(new MovieRental(mulan, 2));
        assertEquals("Rental Record for " + johnDoeJr._name + "\n"
                        + "\t" + mulan.get_title() + "\t" + "1.5"
                        + "\n" + "\t" + mulan.get_title() + "\t" + "1.5"
                        + "\n" + "Amount owed is " + 3.0 + "\n"
                        + "You earned " + 2 + " frequent renter points"
                , johnDoeJr.statement());

        johnDoeJr.addMovieRental(new MovieRental(mulan, 3));
        assertEquals("Rental Record for " + johnDoeJr._name + "\n"
                        + "\t" + mulan.get_title() + "\t" + "1.5"
                        + "\n" + "\t" + mulan.get_title() + "\t" + "1.5"
                        + "\n" + "\t" + mulan.get_title() + "\t" + "1.5"
                        + "\n" + "Amount owed is " + 4.5 + "\n"
                        + "You earned " + 3 + " frequent renter points"
                , johnDoeJr.statement());

        johnDoeJr.addMovieRental(new MovieRental(mulan, 4));
        assertEquals("Rental Record for " + johnDoeJr._name + "\n"
                        + "\t" + mulan.get_title() + "\t" + "1.5"
                        + "\n" + "\t" + mulan.get_title() + "\t" + "1.5"
                        + "\n" + "\t" + mulan.get_title() + "\t" + "1.5"
                        + "\n" + "\t" + mulan.get_title() + "\t" + "2.75"
                        + "\n" + "Amount owed is " + 7.25 + "\n"
                        + "You earned " + 4 + " frequent renter points"
                , johnDoeJr.statement());
    }

    @Test
    public void testStatementNewReleaseOnly() {
        // new releases cost $3.00/day
        // a rental earns 1 frequent-renter point 1 day; 2 points for 2 or more days
        Customer janeDoe = new Customer("Jane Doe");

        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire, 1));
        assertEquals("Rental Record for " + janeDoe._name + "\n"
                        + "\t" + slumdogMillionaire.get_title() + "\t" + "3.0"
                        + "\n" + "Amount owed is " + 3.0 + "\n"
                        + "You earned " + 1 + " frequent renter points"
                , janeDoe.statement());

        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire, 2));
        assertEquals("Rental Record for " + janeDoe._name + "\n"
                        + "\t" + slumdogMillionaire.get_title() + "\t" + "3.0"
                        + "\n" + "\t" + slumdogMillionaire.get_title() + "\t" + "6.0"
                        + "\n" + "Amount owed is " + 9.0 + "\n"
                        + "You earned " + 3 + " frequent renter points"
                , janeDoe.statement());

        janeDoe.addMovieRental(new MovieRental(slumdogMillionaire, 3));
        assertEquals("Rental Record for " + janeDoe._name + "\n"
                        + "\t" + slumdogMillionaire.get_title() + "\t" + "3.0"
                        + "\n" + "\t" + slumdogMillionaire.get_title() + "\t" + "6.0"
                        + "\n" + "\t" + slumdogMillionaire.get_title() + "\t" + "9.0"
                        + "\n" + "Amount owed is " + 18.0 + "\n"
                        + "You earned " + 5 + " frequent renter points"
                , janeDoe.statement());
    }
}