package com.github.nikolaiKorenev99.software_reengineering_and_verification.module_test_1;

import org.junit.*;

/**
 * @author Vycheslav and Mykola Korenev
 */
public class AddItemTest {
    private ShoppingCart cart;

    @Before
    public void createCart() {
        cart = new ShoppingCart();
    }

    @Test
    public void addCorrectItem() {
        cart.addItem("Title regular", 5, 1, Item.Type.REGULAR);
        cart.addItem("Title discount ", 10, 800, Item.Type.DISCOUNT);
        cart.addItem("Title second", 100, 900, Item.Type.SECOND);
        cart.addItem("Title sale", 999, 999, Item.Type.SALE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullTitle() {
        cart.addItem(null, 5, 1, Item.Type.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyTitle() {
        cart.addItem("", 5, 1, Item.Type.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void longTitle() {
        cart.addItem("longTitle test for the cart 37 length", 5, 1, Item.Type.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroPrice() {
        cart.addItem("Title", 0.00, 1, Item.Type.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moreThanOneAllowedPrice() {
        cart.addItem("Title", 1001.00, 1, Item.Type.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zeroGoodsCount() {
        cart.addItem("Title", 1.00, 0, Item.Type.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void moreThanAllowedGoodsCount() {
        cart.addItem("Title", 1.00, 1001, Item.Type.REGULAR);
    }

    @Test(expected = IllegalArgumentException.class)
    public void notAllowedGoodsType() {
        cart.addItem("Title", 800.00, 1, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void notAllowedItemCount() {
        createCart();
        for (int i = 0; i < 100; i++) {
            cart.addItem("notAllowedItemCount number " + i + 1,
                    (i + 1) * 9, (i + 1) * 9, Item.Type.REGULAR);
        }
    }
}
