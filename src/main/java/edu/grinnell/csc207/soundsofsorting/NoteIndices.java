package edu.grinnell.csc207.soundsofsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A collection of indices into a Scale object. These indices are the subject of
 * the various sorting algorithms in the program.
 */
public class NoteIndices {

    public Integer[] arr;
    public Boolean[] highlights;
    public int size;

    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        this.arr = new Integer[n];
        this.highlights = new Boolean[n];
        for (int i = 0; i < n; i++) {
            this.highlights[i] = false;
        }
        this.size = n;
    }

    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size. The collection is also shuffled to provide an initial
     * starting point for the sorting process.
     *
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        List<Integer> lst = new ArrayList<Integer>();
        this.highlights = new Boolean[n];
        this.arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            lst.add(i);
        }
        Collections.shuffle(lst);

        this.arr = lst.toArray(this.arr);
        for (int i = 0; i < n; i++) {
            this.highlights[i] = false;
        }
        this.size = n;
    }

    /**
     * @return the indices of this NoteIndices object
     */
    public Integer[] getNotes() {
        return this.arr;
    }

    /**
     * @return the indices of this NoteIndices object
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Highlights the given index of the note array
     *
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        this.highlights[index] = true;
    }

    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return this.highlights[index];
    }

    /**
     * Clears all highlighted indices from this collection
     */
    public void clearAllHighlighted() {
        for (int i = 0; i < this.highlights.length; i++) {
            this.highlights[i] = false;
        }
    }
}
