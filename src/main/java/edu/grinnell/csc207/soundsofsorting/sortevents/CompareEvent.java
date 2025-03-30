package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 */
public class CompareEvent<T> implements SortEvent<T>{
    
    int firstindex;
    int secondindex;
    
    public CompareEvent(int firstindex,int secondindex){
        firstindex = this.firstindex;
        secondindex = this.secondindex;
    }
    
    @Override
    public void apply(T[] arr){
    }
    
    @Override
    public List<Integer> getAffectedIndices(){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(this.firstindex);
        lst.add(this.secondindex);
        return lst;
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean isEmphasized(){
        return false;
    }
}
