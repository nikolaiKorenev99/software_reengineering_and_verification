package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab3;

/**
 * Mimics functional empty list.
 *
 * @author Vyacheslav Moskalenko
 * @since JDK1.4
 */
public class Empty extends FunList {
    private static Empty instance = new Empty();

    private Empty() {
    }

    /**
     * Method for get instance of the Empty class.
     *
     * @return instance
     */
    public static Empty UniqueInstance() {
        return instance;
    }

    /**
     * It is the overridden  method of FunList for get first(Head) int in the list object.
     *
     * @return int value
     */
    @Override
    public int car() {
        throw new java.util.NoSuchElementException("car requires a non Empty Funlist");
    }

    /**
     * It is the overridden method of FunList for get tail (all but the first element) of the list object
     *
     * @return FunList
     */
    @Override
    public FunList cdr() {
        throw new java.util.NoSuchElementException("cdr requires a non Empty Funlist");
    }

    /***
     * It is the overridden method of FunList for append objects to list.
     * @param other objects to append to list
     * @return empty FunList
     */
    @Override
    public FunList append(FunList other) {
        throw new java.util.NoSuchElementException("append requires a non Empty Funlist");
    }

    /**
     * It is the overridden method of FunList for sorting list.
     *
     * @return empty list
     */
    @Override
    public FunList sort() {
        throw new java.util.NoSuchElementException("sort requires a non Empty Funlist");
    }

    /**
     * It is the overridden method of FunList for sorting and inserting an item into a list.
     *
     * @param i item for insert in list.
     * @return FunList
     */
    @Override
    public FunList insertInOrder(int i) {
        throw new java.util.NoSuchElementException("insertInOrder requires a non Empty Funlist");
    }

    /**
     * @return a String description of the list object
     */
    @Override
    String toStringHelp() {
        return "";
    }
}