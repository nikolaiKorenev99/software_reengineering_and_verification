package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab3;

/**
 * The class for testing Singleton.
 *
 * @author Nikolai Korenev
 * @since JDK1.4
 */
public class AppendTest {
    /**
     * Method for testing Singleton and append method.
     *
     * @param args String arguments
     */
    public static void main(String[] args) {
        System.out.println("AppendTest");
        Cons cons = new Cons(10,new Cons(4));
        cons.append(new Cons(15));
        cons.append(new Cons(8));
        cons.append(new Cons(4));
        cons.append(new Cons(12));
        cons.append(new Cons(10));
        System.out.println(cons.toStringHelp());
    }
}

