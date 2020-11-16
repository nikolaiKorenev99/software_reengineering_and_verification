package com.github.nikolaiKorenev99.software_reengineering_and_verification.Lab3;

/**
 * Mimics fundamental function cons for constructs
 * memory objects which hold two values or pointers to values
 *
 * @author Vyacheslav Moskalenko
 * @since JDK1.4
 */
public class Cons extends FunList {

    private int _dat;
    private FunList _cdr;

    /**
     * Constructor for Cons class.
     *
     * @param carDat a left side (head) of the list
     * @param cdr    a Right side (tail) of the list
     */
    public Cons(int carDat, FunList cdr) {
        _dat = carDat;
        _cdr = cdr;
    }

    /**
     * Constructor for Cons class.
     *
     * @param i a left side (head) of the list.
     */
    public Cons(int i) {
        _dat = i;
        _cdr = Empty.UniqueInstance();
    }

    /**
     * It is the overridden in method of FunList for get first(Head) int in the list object.
     *
     * @return int value
     */
    @Override
    public int car() {
        return _dat;
    }

    /**
     * It is the overridden method of FunList for get tail (all but the first element) of the list object
     *
     * @return FunList
     */
    @Override
    public FunList cdr() {
        return _cdr;
    }

    /**
     * It is the overridden method of FunList for sorting and inserting an item into a list.
     *
     * @param i item for insert in list.
     * @return FunList
     */
    @Override
    public FunList insertInOrder(int i) {
        FunList orderedList = orderLocalCopy(this);
        FunList tempFunList = orderedList;

        boolean isFirtsIteration = true;
        for (FunList tmp = orderedList; !(tmp instanceof Empty); tmp = tmp.cdr()) {
            if (i <= orderedList.car() && isFirtsIteration) {
                return new Cons(i).append(orderedList);
            }
            isFirtsIteration = false;

            if (!(tmp.cdr() instanceof Empty) && i <= tmp.cdr().car()) {
                ((Cons) tmp)._cdr = new Cons(i).append(tmp.cdr());
                return orderedList;
            } else if (tmp.cdr() instanceof Empty) {
                ((Cons) tmp)._cdr = new Cons(i);
                return orderedList;
            }
        }
        return orderedList;
    }

    /**
     * It is the overridden method of FunList to append objects to list.
     *
     * @param other objects to append to list
     * @return FunList
     */
    @Override
    public FunList append(FunList other) {
        return recursiveCall(this, other);
    }

    /**
     * It is the overridden method of FunList for sorting.
     *
     * @return sorted Funlist.
     */
    @Override
    public FunList sort() {
        return orderLocalCopy(this);
    }

    /**
     * @return a String description of the list object
     */
    @Override
    String toStringHelp() {
        return " " + _dat + _cdr.toStringHelp();
    }

    /**
     * Private method for find the tail of the list and to add a new list in the end.
     *
     * @param tempCons current list
     * @param other    new list that need to add
     * @return linked list
     */
    private Cons recursiveCall(Cons tempCons, FunList other) {
        if (tempCons.cdr() instanceof Empty) {
            tempCons._cdr = other;
            return tempCons;
        } else {
            return recursiveCall((Cons) tempCons.cdr(), other);
        }
    }

    /**
     * Private method for create sorted list without changing source list.
     *
     * @param list source list
     * @return new sorted list
     */
    private FunList orderLocalCopy(FunList list) {
        class TempCons {
            int head;
            TempCons link;
        }

        TempCons tempCons = new TempCons();
        FunList funList = list;

        TempCons firstElement = tempCons;
        int index = 0;
        int elementCount = 0;
        while (!(funList instanceof Empty)) {
            tempCons.head = funList.car();
            tempCons.link = new TempCons();
            if (index == 0) {
                firstElement = tempCons;
                index++;
            }
            elementCount++;

            if (funList.cdr() instanceof Empty) {
                tempCons.link = null;
            } else {
                tempCons = tempCons.link;
            }
            funList = funList.cdr();
        }
        for (int iterator = 0; iterator <= elementCount / 2; iterator++) {
            TempCons variableTampCons = null;
            TempCons variableTampCons2 = null;
            TempCons previous = null;
            for (TempCons tmp = firstElement; tmp != null; tmp = tmp.link) {
                if (tmp.link != null && tmp.head > tmp.link.head) {
                    if (previous != null) {
                        variableTampCons = previous.link;
                        previous.link = tmp.link;
                        variableTampCons2 = tmp.link.link;
                        tmp.link.link = variableTampCons;
                        tmp.link = variableTampCons2;
                    } else {
                        int temp_value = tmp.head;
                        tmp.head = tmp.link.head;
                        tmp.link.head = temp_value;
                    }
                }
                previous = tmp;
            }
        }
        FunList newFunlist = null;
        for (TempCons tmp = firstElement; tmp != null; tmp = tmp.link) {
            if (newFunlist == null) {
                newFunlist = new Cons(tmp.head);
            } else {
                newFunlist.append(new Cons(tmp.head));
            }
        }

        return newFunlist;
    }
}