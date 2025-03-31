package edu.grinnell.csc207.soundsofsorting;

import edu.grinnell.csc207.soundsofsorting.sortevents.SortEvent;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.soundsofsorting.sorts.Sorts;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class SortsTests {
    /**
     * @param <T> the carrier type of the array
     * @param arr the array to check
     * @return true iff <code>arr</code> is sorted.
     */
    public static <T extends Comparable<? super T>> boolean sorted(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static Integer[] makeTestArray() {
        return new Integer[] {
            3, 7, 9, 1, 2,
            18, 16, 15, 19, 8,
            14, 12, 5, 13, 4,
            6, 0, 17, 11, 10
        };
    }
    
    public static Integer[] makeTestArrayNegatives() {
        return new Integer[] {
            -3, 7, -9, 1, 2,
            18, 16, 15, -19, -8,
            14, -12, 5, 13, 4,
            -6, 0, 17, -11, -10
        };
    }
    
    public static Integer[] makeTestArrayZero() {
        return new Integer[] {};
    }

    public void testSortZero(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArrayZero();
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    public void testSortNegatives(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArrayNegatives();
        func.accept(arr);
        assertTrue(sorted(arr));
    }
    
    public void testSort(Consumer<Integer[]> func) {
        Integer[] arr = makeTestArray();
        func.accept(arr);
        assertTrue(sorted(arr));
    }

    @Test
    public void testBubbleSort() {
        testSort(Sorts::bubbleSort);
    }
    
    @Test
    public void testBubbleSortEmpty() {
        testSortZero(Sorts::bubbleSort);
    }
    
    @Test
    public void testBubbleSortNegatives() {
        testSortNegatives(Sorts::bubbleSort);
    }
    
    @Test
    public void testInsertionSort() {
        testSort(Sorts::insertionSort);
    }
    
    @Test
    public void testInsertionSortNegatives() {
        testSortNegatives(Sorts::insertionSort);
    }
    
    @Test
    public void testInsertionSortEmpty() {
        testSortZero(Sorts::insertionSort);
    }
    
    @Test
    public void testSelectionSort() {
        testSort(Sorts::selectionSort);
    }
    
    @Test
    public void testSelectionSortNegatives() {
        testSortNegatives(Sorts::selectionSort);
    }

    @Test
    public void testSelectionSortEmpty() {
        testSortZero(Sorts::selectionSort);
    }

    @Test
    public void testMergeSort() {
        testSort(Sorts::mergeSort);
    }
    
    @Test
    public void testMergeSortNegatives() {
        testSortNegatives(Sorts::mergeSort);
    }

    @Test
    public void testMergeSortEmpty() {
        testSortZero(Sorts::mergeSort);
    }
    
    @Test
    public void testQuickSort() {
        testSort(Sorts::quickSort);
    }
    
    @Test
    public void testQuickSortNegatives() {
        testSortNegatives(Sorts::quickSort);
    }
    
    @Test
    public void testQuickSortEmpty() {
        testSortZero(Sorts::quickSort);
    }
    
    @Test
    public void testCombSort() {
        testSort(Sorts::combSort);
    }
    
    @Test
    public void testCombSortNegatives() {
        testSortNegatives(Sorts::combSort);
    }
    
    @Test
    public void testCombSortEmpty() {
        testSortZero(Sorts::combSort);
    }
    
    public void testSortEvent(Function<Integer[],  List<SortEvent<Integer>>> func1, BiConsumer<Integer[], List<SortEvent<Integer>>> func2) {
        List<SortEvent<Integer>> lst = new ArrayList<SortEvent<Integer>>();
        Integer[] arr = makeTestArray();
        Integer[] arr1 = arr.clone();
        lst = func1.apply(arr);
        func2.accept(arr1, lst);
        assertTrue(sorted(arr1));
    }
    
    @Test
    public void testEventBubbleSort() {
        testSortEvent(Sorts::bubbleSort, Sorts::eventSort);
    }

}