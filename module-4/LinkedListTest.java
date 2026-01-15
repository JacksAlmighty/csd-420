// Jackson Webster
// 1/15/2026
// Advanced Java Programming
// This program measures and compares how long it takes to traverse a LinkedList 
// using an Iterator versus using the get(index) method. 
// It tests both a small list (50,000 elements) and a large list (500,000 elements) 
// and prints the traversal times for each method.

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main (String[] args) {
        // Run the test with a smaller list
        testTraversal(50000);
        // Run the test with a larger list
        testTraversal(500000);
    }
    public static void testTraversal(int size) {
        System.out.println("\n--- Starting test for list size: " + size + " ---");
        
        // Create a LinkedList and fill it with integers from 0 to size-1
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        
        // Measure time to traverse the list using an Iterator
        long startIterator = System.nanoTime();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
        
        long endIterator = System.nanoTime();
        long iteratorTime = endIterator - startIterator;

        // Measure time to traverse the list using get(index)
        long startGet = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        
            if (i % 50000 == 0 && i != 0) {
                System.out.println ("Reached index " + i + " of " + list.size());
            }
        }

        long endGet = System.nanoTime();
        long getTime = endGet - startGet;
    
        // Convert nanoseconds to seconds for easier reading
        double iteratorSeconds = iteratorTime / 1_000_000_000.0;
        double getSeconds = getTime / 1_000_000_000.0;
        
        System.out.println("\nList size: " + size);
        System.out.println(String.format("Iterator traversal time: %,d ns (%.3f seconds)", iteratorTime, iteratorSeconds));
        System.out.println(String.format("get(index) traversal time: %,d ns (%.3f seconds)", getTime, getSeconds));
        
        // Correctness test: check size and first/last elements
        if(list.size() == size &&
        list.getFirst() == 0 &&
        list.getLast() == size - 1) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    
    }

    
}