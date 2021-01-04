package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly;

public class FreeParkingCell extends Cell {

    private boolean available = true;

    public FreeParkingCell() {
		setName("Free Parking");
	}

	public void playAction() {
		return;
	}

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
