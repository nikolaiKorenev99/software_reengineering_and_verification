package com.github.nikolaiKorenev99.software_reengineering_and_verification.module_test_2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AppendFormattedTest {
    private static final StringBuilder[] sbs = {
            new StringBuilder(),
            new StringBuilder("Word "),
            new StringBuilder("Many other words "),
    };

    private static final String[] values = {
            "", "Value", "Many words value",
    };

    private static final int[] aligns = {-1, 0, 1};
    private static final int[] widths = {10, 20};

    private static final String[][][][] expected = {
            {
                    {
                            {"           ", "                     "},
                            {"           ", "                     "},
                            {"           ", "                     "}
                    },
                    {
                            {"Value      ", "Value                "},
                            {"  Value    ", "       Value         "},
                            {"     Value ", "               Value "}
                    },
                    {
                            {"Many words ", "Many words value     "},
                            {"Many words ", "  Many words value   "},
                            {"Many words ", "    Many words value "}
                    }
            },
            {
                    {
                            {"Word            ", "Word                      "},
                            {"Word            ", "Word                      "},
                            {"Word            ", "Word                      "}
                    }, {
                    {"Word Value      ", "Word Value                "},
                    {"Word   Value    ", "Word        Value         "},
                    {"Word      Value ", "Word                Value "}
            }, {
                    {"Word Many words ", "Word Many words value     "},
                    {"Word Many words ", "Word   Many words value   "},
                    {"Word Many words ", "Word     Many words value "}
            }
            }, {
            {
                    {"Many other words            ", "Many other words                      "},
                    {"Many other words            ", "Many other words                      "},
                    {"Many other words            ", "Many other words                      "}
            }, {
            {"Many other words Value      ", "Many other words Value                "},
            {"Many other words   Value    ", "Many other words        Value         "},
            {"Many other words      Value ", "Many other words                Value "}
    }, {
            {"Many other words Many words ", "Many other words Many words value     "},
            {"Many other words Many words ", "Many other words   Many words value   "},
            {"Many other words Many words ", "Many other words     Many words value "}
    }
    }
    };

    @Parameterized.Parameters
    @SuppressWarnings("unchecked")
    public static Collection getTypeQuantityPairs() {
        Collection pairs = new ArrayList();

        for (int i1 = 0; i1 < sbs.length; i1++) {
            for (int i2 = 0; i2 < sbs.length; i2++) {
                for (int i3 = 0; i3 < aligns.length; i3++) {
                    for (int i4 = 0; i4 < widths.length; i4++) {
                        pairs.add(new Object[]{
                                sbs[i1], values[i2], aligns[i3], widths[i4], expected[i1][i2][i3][i4]
                        });
                    }
                }
            }
        }
        return pairs;
    }

    private StringBuilder _sb;
    private String _value;
    private int _align;
    private int _width;
    private String _expected;

    public AppendFormattedTest(StringBuilder sb, String value, int align, int width, String expected) {
        _sb = new StringBuilder(sb);
        _value = value;
        _align = align;
        _width = width;
        _expected = expected;
    }

    @Test
    public void discountTest() {
        ShoppingCart.appendFormatted(_sb, _value, _align, _width);
        assertEquals("sb: " + _sb + "; value: " + _value + "; align:" + _align + "; width: " + _width,
                _expected, _sb.toString());
    }
}

