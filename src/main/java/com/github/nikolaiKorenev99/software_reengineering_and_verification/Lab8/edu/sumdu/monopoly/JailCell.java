package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly;

public class JailCell extends Cell {
	public static int BAIL = 50;
    private boolean available = true;

    public JailCell() {
		setName("Jail");
	}
	
	public void playAction() {
		
	}

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
