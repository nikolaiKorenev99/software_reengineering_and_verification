package com.github.nikolaiKorenev99.software_reengineering_and_verification.module_test_1;

import org.junit.*;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.runners.*;
import org.junit.runner.*;

@RunWith(Parameterized.class)
public class DiscountTest {
    private static final int[] Q_VALUES = {1, 9, 10, 19, 50, 100, 1000};
    private static final Item.Type[] T_VALUES = {
            Item.Type.SECOND,
            Item.Type.REGULAR,
            Item.Type.SALE,
            Item.Type.DISCOUNT
    };
    private static final int[][] D_VALUES =
            {
                    {0, 50, 50, 50, 50, 60, 80}, //SECOND
                    {0, 0, 0, 0, 0, 10, 80}, //REGULAR
                    {90, 90, 90, 90, 90, 90, 90}, //SALE
                    {10, 10, 20, 20, 50, 60, 80} //DISCOUNT
            };

    @Parameterized.Parameters
    @SuppressWarnings("unchecked")
    public static Collection getTypeQuantityPairs() {
        Collection pairs = new ArrayList();
        for (int q = 0; q < Q_VALUES.length; q++)
            for (int t = 0; t < T_VALUES.length; t++)
                pairs.add(new Object[]{
                        T_VALUES[t],
                        Q_VALUES[q],
                        (D_VALUES[t].length > q)
                                ? D_VALUES[t][q]
                                : D_VALUES[t][D_VALUES[t].length - 1]
                });
        return pairs;
    }

    private Item.Type _type;
    private int _quantity;
    private int _discount;

    public DiscountTest(Item.Type type, int quantity, int discount) {
        _type = type;
        _quantity = quantity;
        _discount = discount;
    }

    @Test
    public void discountTest() {
        assertEquals("type: " + _type + ", quantity: " + _quantity,
                _discount,
                ShoppingCart.calculateDiscount(
                        new Item("Title", 5.99f, _type, _quantity)
                ),
                0.01f
        );
    }
}