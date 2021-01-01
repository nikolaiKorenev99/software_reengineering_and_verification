package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab5;

import org.junit.*;
import org.junit.Ignore;
import static org.junit.Assert.*;

public class UtilsJUnit4Test {

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("* UtilsJUnit4Test: @BeforeClass method");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("* UtilsJUnit4Test: @AfterClass method");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("* UtilsJUnit4Test: @Before method");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("* UtilsJUnit4Test: @After method");
    }

    @Test
    public void helloWorldCheck() {
        System.out.println("* UtilsJUnit4Test: test method 1 - helloWorldCheck");
        assertEquals("Hello,world!", Utils.concatWords("Hello", ",", "world", "!"));
    }

    @Test
    public void testWithTimeout() {
        final int factorialOf = 1 + (int) (30000 * Math.random());
        System.out.println("computing " + factorialOf + '!');
        System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
    }

    @Test(timeout = 1000)
    public void testWithTimeout2() {
        System.out.println("* UtilsJUnit4Test: test method 2 - test WithTimeout");
        final int factorialOf = 1 + (int) (30000 * Math.random());
        System.out.println("computing " + factorialOf + '!');
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkExpectedException() {
        System.out.println("* UtilsJUnit4Test: test method 3 - checkExpectedException()");
        final int factorialOf = -5;
        System.out.println(factorialOf + "! = " + Utils.computeFactorial(factorialOf));
    }

    @Ignore
    @Test
    public void temporarilyDisabledTest() throws Exception{
        System.out.println("* UtilsJUnit4Test: test method 4 - checkExpectedException()");
        assertEquals("Malm\u00f6", Utils.normalizeWord("Malmo\u0308"));
    }
}
