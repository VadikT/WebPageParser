package trachuk.vadim.projects.sorter;

public class DoWhileLoopSorter implements MySortable {
    @Override
    public String[] sort(String[] array) {
        String sortedArray[] = array;//скопировать массив
        int i = 0;
        int j = i + 1;
        do {
            i++;
        } while (i < sortedArray.length-1);{
            do {
                j++;
                if (sortedArray[j].compareTo(sortedArray[i]) < 0) {
                    String element = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = element;
                }

            } while (j < sortedArray.length - 1);

        }
        return sortedArray;
    }
}
