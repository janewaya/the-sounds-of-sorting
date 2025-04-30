package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T> {

    private T value;
    private int destination;

    /**
     * Creates a CopyEvent
     *
     * @param value the value being copied
     * @param destination the index it is copied from
     */
    public CopyEvent(T value, int destination) {
        this.value = value;
        this.destination = destination;
    }

    /**
     * Applies a CopyEvent
     *
     * @param arr the array the event is applied to
     */
    @Override
    public void apply(T[] arr) {
        arr[this.destination] = this.value;
    }

    /**
     * Gets where a CopyEvent occurred
     *
     * @return A list containing where the affected index was
     */
    @Override
    public List<Integer> getAffectedIndices() {
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(this.destination);
        return lst;
    }

    /**
     * Tells if a CopyEvent is Emphasized
     *
     * @return true
     */
    @Override
    public boolean isEmphasized() {
        return true;
    }
}
