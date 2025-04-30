package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {

    private int firstindex;
    private int secondindex;

    /**
     * Creates a SwapEvent
     *
     * @param firstindex the first index swapped
     * @param secondindex the second index swapped
     */
    public SwapEvent(int firstindex, int secondindex) {
        this.firstindex = firstindex;
        this.secondindex = secondindex;
    }

    /**
     * Applies a SwapEvent
     *
     * @param arr the array the event is applied to
     */
    @Override
    public void apply(T[] arr) {
        T temp = arr[this.firstindex];
        arr[this.firstindex] = arr[this.secondindex];
        arr[this.secondindex] = temp;
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
     * Tells if a SwapEvent is Emphasized
     *
     * @return true
     */
    @Override
    public boolean isEmphasized() {
        return true;
    }
}
