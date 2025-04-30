package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T> {

    private int firstindex;
    private int secondindex;

    /**
     * Creates a CompareEvent
     *
     * @param firstindex the first index compared
     * @param secondindex the second index compared
     */
    public CompareEvent(int firstindex, int secondindex) {
        this.firstindex = firstindex;
        this.secondindex = secondindex;
    }

    /**
     * "Applies" a CompareEvent (does nothing)
     *
     * @param arr the first index compared
     */
    @Override
    public void apply(T[] arr) {
    }

    /**
     * Gets the compared indices
     *
     * @return a list of the compared indices
     */
    @Override
    public List<Integer> getAffectedIndices() {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(this.firstindex);
        lst.add(this.secondindex);
        return lst;
    }

    /**
     * Tells if a CompareEvent is Emphasized
     * 
     * @return false
     */
    @Override
    public boolean isEmphasized() {
        return false;
    }
}
