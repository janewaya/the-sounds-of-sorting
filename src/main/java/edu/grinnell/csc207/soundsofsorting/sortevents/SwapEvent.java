package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {

    private int firstindex;
    private int secondindex;

    public SwapEvent(int firstindex, int secondindex) {
        this.firstindex = firstindex;
        this.secondindex = secondindex;
    }

    /**
     *
     * @param arr
     */
    @Override
    public void apply(T[] arr) {
        T temp = arr[this.firstindex];
        arr[this.firstindex] = arr[this.secondindex];
        arr[this.secondindex] = temp;
    }

    public List<Integer> getAffectedIndices() {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(this.firstindex);
        lst.add(this.secondindex);
        return lst;
    }

    public boolean isEmphasized() {
        return true;
    }
}
