package trachuk.vadim.projects.sorter;

public class WhileLoopSorter implements MySortable{
    @Override
    public String[] sort(String[] array) {
        String sortedArray[] = array;
        int i = 0;
        int j = i + 1;
        while (i < sortedArray.length) {
            i++;
            while (j < sortedArray.length - 1) {
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
    }

