package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab8.edu.sumdu.monopoly;

public class CardCell extends Cell {
    private int type;
    private boolean available = true;

    public CardCell(int type, String name) {
        setName(name);
        this.type = type;
    }
    
    public void playAction() {
    }
    
    public int getType() {
        return type;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
