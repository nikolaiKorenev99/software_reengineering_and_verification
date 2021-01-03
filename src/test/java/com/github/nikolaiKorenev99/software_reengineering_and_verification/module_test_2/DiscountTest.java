package com.github.nikolaiKorenev99.software_reengineering_and_verification.module_test_2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static com.github.nikolaiKorenev99.software_reengineering_and_verification.module_test_2.Item.ItemType.*;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DiscountTest {
    private static final int[] Q_VALUES = {1, 9, 10, 19, 50, 100, 1000};
    //    private static final Item.Type[] T_VALUES = {
//            Item.Type.SECOND,
//            Item.Type.REGULAR,
//            Item.Type.SALE,
//            Item.Type.DISCOUNT
//    };
    private static final Item.ItemType[] T_VALUES = new Item.ItemType[]{NEW, REGULAR, SECOND_FREE, SALE};
    private static final int[][] D_VALUES =
            {
                    {0, 0, 0, 0, 0, 0, 0}, //NEW
                    {0, 0, 1, 1, 5, 10, 80}, //REGULAR
                    {0, 50, 51, 51, 55, 60, 80}, //SECOND_FREE
                    {70, 70, 71, 71, 75, 80, 80} //SALE
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

    private Item.ItemType _type;
    private int _quantity;
    private int _discount;

    public DiscountTest(Item.ItemType type, int quantity, int discount) {
        _type = type;
        _quantity = quantity;
        _discount = discount;
    }

    @Test
    public void discountTest() {
        assertEquals("type: " + _type + ", quantity: " + _quantity,
                _discount,
                ShoppingCart.calculateDiscount(
                        _type, _quantity
                ),
                0.01f
        );
    }
}