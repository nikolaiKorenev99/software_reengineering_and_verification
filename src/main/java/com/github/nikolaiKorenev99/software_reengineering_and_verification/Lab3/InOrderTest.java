package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab3;

/**
 * The class for testing method insertInOrder.
 *
 * @author Nikolai Korenev
 * @since JDK1.4
 */
public class InOrderTest {
    /**
     * Method for testing insertInOrder method.
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
        System.out.println("Insert 1 " + insertInOrderTest.insertInOrder(1).toStringHelp());
        System.out.println("Insert 11 " + insertInOrderTest.insertInOrder(11).toStringHelp());
        System.out.println("Insert 21 " + insertInOrderTest.insertInOrder(21).toStringHelp());
        System.out.println("Original FunList " + insertInOrderTest.toStringHelp());
    }
}

