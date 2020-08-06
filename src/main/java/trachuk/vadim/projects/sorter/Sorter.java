package trachuk.vadim.projects.sorter;

import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Sorter {


    public String[] sortByForLoop(String[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = j + 1; i < array.length; i++) {
                if (array[i].compareTo(array[j]) < 0) {
                    String element = array[j];
                    array[j] = array[i];
                    array[i] = element;
                }
            }
        }
        return array;
    }

    public String[] sortByWhileLoop(String array[]) {
        String sortedArray[] = array;
        int i = 0;
        int j = i + 1;
        while (i < sortedArray.length) {
            i++;
            while (j < sortedArray.length) {
                j++;
                if (sortedArray[j].compareTo(sortedArray[i]) < 0) {
                    String element = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = element;
                }
            }
        }

        return array;
    }


    public String[] sortByDoWhileLoop(String array[]) {
        String sortedArray[] = array;//скопировать массив
        int i = 0;
        int j = i + 1;
        do {
            i++;
        } while (i < sortedArray.length);{
            do {
                j++;
                if (sortedArray[j].compareTo(sortedArray[i]) < 0) {
                    String element = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = element;
                }

            } while (j < sortedArray.length);

        }
        return sortedArray;
    }
}