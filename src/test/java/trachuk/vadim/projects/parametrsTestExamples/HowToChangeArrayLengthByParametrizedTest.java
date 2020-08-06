package trachuk.vadim.projects.parametrsTestExamples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import trachuk.vadim.projects.sorter.DoWhileLoopSorter;
import trachuk.vadim.projects.sorter.ForLoopSorter;
import trachuk.vadim.projects.sorter.MySortable;
import trachuk.vadim.projects.sorter.WhileLoopSorter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class HowToChangeArrayLengthByParametrizedTest {
    public static Stream<MySortable> getImplemetationsOfMySortable(){
        return Stream.of(new ForLoopSorter(), new WhileLoopSorter(), new DoWhileLoopSorter());
    }

    public static Stream<Integer> getArraySizes(){
        return Stream.of(0, 1, 3, 7, 10, 31, 117, 1024, 12345, 1234567);
    }

    private  String[] randomGenerateArray(Integer arraySize) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)

                .limit(arraySize)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return new String[]{generatedString};

    }
public  MySortable[]  sortMethods(){
    List list = new LinkedList();
    list.add(new ForLoopSorter());
    list.add(new WhileLoopSorter());
    list.add(new DoWhileLoopSorter());
    return  (MySortable[]) list.toArray(new MySortable[list.size()]);
}

    @ParameterizedTest
    @MethodSource({"getArraySizes"})
//    @ValueSource()//придумать как загнать сюда все 3 сразу класса на сортировку
    void testChangeArrayLengthByForLoopSort( Integer arraySize) {
        String[] randomArray = randomGenerateArray(arraySize);
        String[] mySortableArray = new ForLoopSorter().sort(randomArray);//
        Arrays.sort(randomArray);
        Assertions.assertEquals(randomArray, mySortableArray);
    }
    @ParameterizedTest
    @MethodSource({"getArraySizes"})
//    @ValueSource()//придумать как загнать сюда все 3 сразу класса на сортировку
    void testChangeArrayLengthByDoWhileLoopSort( Integer arraySize) {
        String[] randomArray = randomGenerateArray(arraySize);
        String[] mySortableArray = new DoWhileLoopSorter().sort(randomArray);//
        Arrays.sort(randomArray);
        Assertions.assertEquals(randomArray, mySortableArray);
    }
    @ParameterizedTest
    @MethodSource({"getArraySizes"})
//    @ValueSource(W)
    void testChangeArrayLengthByWhileLoopSort( Integer arraySize) {
        String[] randomArray = randomGenerateArray(arraySize);
        String[] mySortableArray = new WhileLoopSorter().sort(randomArray);//
        Arrays.sort(randomArray);
        Assertions.assertEquals(randomArray, mySortableArray);
    }

    @ParameterizedTest
    @MethodSource("sortMethods")
    void rere(MySortable mySortable){
        mySortable.sort()
    }

}
