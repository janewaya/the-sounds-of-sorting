package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 */
public class CopyEvent<T> implements SortEvent<T>{
    
    T value;
    int destination;
    
    public CopyEvent(T value,int destination){
        value = this.value;
        destination = this.destination;
    }
    
    @Override
    public void apply(T[] arr){
        arr[this.destination] = this.value;
    }
    
    public List<Integer> getAffectedIndices(){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(this.destination);
        return lst;
    }
    
    public boolean isEmphasized(){
        return true;
    }
}
