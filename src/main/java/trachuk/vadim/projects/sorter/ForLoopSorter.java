package trachuk.vadim.projects.sorter;

public class ForLoopSorter implements MySortable {
    @Override
    public String[] sort(String[] array) {
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

}
