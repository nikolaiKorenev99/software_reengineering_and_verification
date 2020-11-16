package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab3;

/**
 * The class for testing method sort.
 *
 * @author Nikolai Korenev
 * @since JDK1.4
 */
public class SortedTest {
    /**
     * Method for testing sort method.
     *
     * @param args String arguments
     */
    public static void main(String[] args) {
        Cons cons = new Cons(10, new Cons(4));
        cons.append(new Cons(15));
        cons.append(new Cons(9));
        cons.append(new Cons(7));
        cons.append(new Cons(12));
        cons.append(new Cons(13));

        FunList insertInOrderTest = new Cons(5, new Cons(8));
        insertInOrderTest.append(cons);
        System.out.println("Original FunList " + insertInOrderTest.toStringHelp());
        System.out.println("Sorted" + insertInOrderTest.sort());
    }
}
