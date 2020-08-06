package trachuk.vadim.projects.sorter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.manipulation.Sortable;

import java.util.*;

public class SorterTest {
    @Test
    public void testSortByForLoop() {
        String[] array = {"a", "e", "b"};
        Sorter sorter = new Sorter();

        String[] sortedArray = sorter.sortByForLoop(array);
        System.out.println(sorter.sortByForLoop(array));
        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals("a", array[0]);
//        Assertions.assertEquals("e", array[1]);
//        Assertions.assertEquals("b", array[2]);

        Assertions.assertEquals(array.length, sortedArray.length);

        for (int i = 0; i < array.length; i++) {
            Assertions.assertEquals(array[i], sortedArray[i]);
        }



    }

    @Test
    public void testSortByWhileLoop() {
        String[] array = {"a", "e", "b"};
        Sorter sorter = new Sorter();

        String[] sortedArray = sorter.sortByForLoop(array);

        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals("a", array[0]);
        Assertions.assertEquals("e", array[1]);
        Assertions.assertEquals("b", array[2]);

        Assertions.assertEquals(array.length, sortedArray.length);

        for (int i = 0; i < array.length; i++) {
            Assertions.assertEquals(array[i], sortedArray[i]);
        }
    }

    @Test
    public void testSortByDoWhileLoop() {
        String[] array = {"a", "e", "b"};
        Sorter sorter = new Sorter();

        String[] sortedArray = sorter.sortByForLoop(array);

        Assertions.assertEquals(3, array.length);
        Assertions.assertEquals("a", array[0]);
        Assertions.assertEquals("e", array[1]);
        Assertions.assertEquals("b", array[2]);

        Assertions.assertEquals(array.length, sortedArray.length);

        for (int i = 0; i < array.length; i++) {
            Assertions.assertEquals(array[i], sortedArray[i]);
        }
    }
@Test
    public void testMethodForLoop(){
        String array[] = generateArray();

        String[] sortedArray = sort(array, new ForLoopSorter());

        assertMethod(array, sortedArray);

    }

    @Test
    public void testMethodWhileLoop(){
        String array[] = generateArray();

        String[] sortedArray = sort(array, new WhileLoopSorter());

        assertMethod(array, sortedArray);
    }

    @Test
    public void testMethodDoWhileLoop(){
        String array[] = generateArray();

        String[] sortedArray = sort(array, new DoWhileLoopSorter());

        assertMethod(array, sortedArray);
    }

    @Test
    public void testMethodForLoopWithRandomGenerateArray(){
        String array[] = randomGenerateArray();

        String[] sortedArray = sort(array, new ForLoopSorter());

        assertMethod(array, sortedArray);
    }

    @Test
    public void testMethodWhileLoopWithRandomGenerateArray(){
        String array[] = randomGenerateArray();

        String[] sortedArray = sort(array, new WhileLoopSorter());

        assertMethod(array, sortedArray);
    }

    @Test
    public void testMethodDoWhileLoopWithRandomGenerateArray(){
        doTestMySorter(new DoWhileLoopSorter());
    }

    private  void doTestMySorter(MySortable sortable){
        String array[] = randomGenerateArray();

        String[] sortedArray = sort(array, sortable);

        assertMethod(array, sortedArray);
    }

    public void assertMethod(String[] originalArray, String[] sortedArray){
        Assertions.assertEquals(originalArray.length, sortedArray.length);
        for (int i = 0; i == originalArray.length; i++){
            if (originalArray[i] != sortedArray[i]){
                Assertions.assertTrue(true);
            }

        }
        String[] originalArrayCopy = new String[originalArray.length];
        for (int i = 0; i< originalArray.length; i++){
            originalArrayCopy[i] = originalArray[i];
        }
        Arrays.sort(originalArrayCopy);
        Assertions.assertArrayEquals(originalArrayCopy, sortedArray);
        //1)проверить длину(что она одинаковая)
        // 2)в цикле фор сравниваю два масива, до того момента пока 2 элемента с одинаковым индексом не будут равны(если орджинал не равен сортед арей все по индексу i- значит они разные)
        // 3)получить отсортированый массив и сравнить его с входящим масивом(беру оригинал, делаю его копию, вызываю стандартную сортировку и её отсортировать и сравнить как в пункте 2(они должны быть равны!))
    }
    private String[] generateArray() {
        String[] array = {"a", "b", "c"};
        return array;
    }
    private String[] sort(String[] array , MySortable sortable){
        return sortable.sort(array);
    }

    private int randomGenerateLength(){
        int targetStringLength = (int) (Math.random() * 10);
        return targetStringLength;
    }

    private  String[] randomGenerateArray() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
//        int targetStringLength = (int) (Math.random()*100);
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(randomGenerateLength())
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return new String[]{generatedString};

    }
    @ParameterizedTest
    @MethodSource("getMySortable")
    public void testMySorteble(MySortable sorter){

        doTestMySorter(sorter);
    }


    public static MySortable[] getMySortable(){
        List list = new  LinkedList() ;
        list.add(new DoWhileLoopSorter());
        list.add(new WhileLoopSorter());
        list.add(new ForLoopSorter());
        return (MySortable[]) list.toArray(new MySortable[list.size()]);
    }
    @ParameterizedTest
    @MethodSource()
    public void testMySortable(MySortable sorter){
        doTestMySorter(sorter);
    }

}
