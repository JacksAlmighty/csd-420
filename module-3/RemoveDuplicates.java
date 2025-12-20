//Jackson Webster
//12/20/2025
//Advanced Java Programming
//This program randomly generates 50 numbers then goes through that list and removes all of the duplicates and returns the new list.

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicates {
    
    //Creates the original list. 50 numbers from 1 - 20.
    public static void main(String[] args) {

        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }
    

        //prints the original list.
        System.out.println("Original ArrayList");
        System.out.println(originalList);

        ArrayList<Integer> noDuplicates = removeDuplicates(originalList);
        //prints the fixed list.
        System.out.println("\nArrayList with duplicates removed:");
        System.out.println(noDuplicates);
    }


    //removes all of the duplicates and places them in a new list.
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> newList = new ArrayList<>();

        for (E element : list) {
            if(!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}