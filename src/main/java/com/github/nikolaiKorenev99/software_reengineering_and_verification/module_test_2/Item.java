package com.github.nikolaiKorenev99.software_reengineering_and_verification.module_test_2;

/**
 * item info
 */
public class Item {
    public static enum ItemType {NEW, REGULAR, SECOND_FREE, SALE}

    ;
    private String title;
    private double price;
    private int quantity;
    private ItemType type;

    public Item(String title, double price, int quantity, ItemType type) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }


}
