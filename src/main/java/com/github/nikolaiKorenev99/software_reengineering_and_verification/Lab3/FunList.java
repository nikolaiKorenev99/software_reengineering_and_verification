package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab3;

/**
 * Mimics functional lists.
 *
 * @author Vyacheslav Moskalenko
 * @since JDK1.4
 */
public abstract class FunList {
    /**
     * Abstract method of FunList.
     *
     * @return the first int in the list object
     */
    public abstract int car();

    /**
     * Abstract method of FunList.
     *
     * @return the tail (all but the first element) of the list object
     */
    public abstract FunList cdr();

    /**
     * Abstract method of FunList for sorting and inserting an item into a list.
     * @param i item for insert in list.
     * @return FunList
     */
    public abstract FunList insertInOrder(int i);

    /**
     * Abstract method of FunList to append objects.
     *
     * @param other objects to append to list
     * @return the tail (all but the first element) of the list object
     */
    public abstract FunList append(FunList other);

    /**
     * Abstract method for sorting Funlist.
     * @return sorted Funlist
     */
    public abstract  FunList sort();
    /**
     * NOTE: toString () method is NOT abstract. It calls, toStringHelp() , an abstract method.
     * It represents what we call an "invariant" behavior for <code>FunList</code>.
     * It is an example of the "Template Method Pattern". A "template method" is a method that
     * makes calls to at least one abstract method in its own class.
     */
    public String toString() {
        return "(" + toStringHelp() + " ) ";
    }

    /**
     * Abstract method of FunList.
     *
     * @return a String description of the list object
     */
    abstract String toStringHelp();
}