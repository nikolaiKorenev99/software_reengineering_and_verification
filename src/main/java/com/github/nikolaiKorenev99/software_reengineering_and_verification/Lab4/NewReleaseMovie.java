package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab4;

public class NewReleaseMovie extends Movie {
    public static final int NUM_DAYS_BASE_CONST = 1;
    public static final double BASE_RENTAL_COST = 3;
    public static final int FREQUENT_RENTER_POINTS = 1;

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int _daysRented) {
        return _daysRented * BASE_RENTAL_COST;
    }

    @Override
    public int getFrequentRenterPoints(int _daysRented) {
        int frequentRenterPoints = FREQUENT_RENTER_POINTS;
        if (_daysRented > NUM_DAYS_BASE_CONST)
            frequentRenterPoints += frequentRenterPoints;
        return frequentRenterPoints;
    }
}
