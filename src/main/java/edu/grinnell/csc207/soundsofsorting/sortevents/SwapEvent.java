package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.ArrayList;
import java.util.List;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 */
public class SwapEvent<T> implements SortEvent<T> {
    
    int firstindex;
    int secondindex;
    
    public SwapEvent(int firstindex,int secondindex){
        firstindex = this.firstindex;
        secondindex = this.secondindex;
    }
    
    /**
     *
     * @param arr
     */
    @Override
    public void apply(T[] arr){
        System.out.println("Swapping\n" + this.firstindex + "\n" + this.secondindex);
        T temp = arr[this.firstindex];
        arr[this.firstindex] = arr[this.secondindex];
        arr[this.secondindex] = temp;
        for(int j = 0; j < arr.length; j++){
                System.out.print(arr[j] + " ");
            }
    }
    
    public List<Integer> getAffectedIndices(){
        ArrayList<Integer> lst = new ArrayList<Integer>();
        lst.add(this.firstindex);
        lst.add(this.secondindex);
        return lst;
    }
    
    public boolean isEmphasized(){
        return true;
    }
}
