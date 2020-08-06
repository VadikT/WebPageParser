package trachuk.vadim.projects.parametrsTestExamples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class Empty {
    public static boolean isBlank(String input) {
        return input == null || input.trim().isEmpty();
    }
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        Assertions.assertTrue(Empty.isBlank(input));
    }

    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        Assertions.assertTrue(Empty.isBlank(input));
    }

    @ParameterizedTest
    @EmptySource
    void isBlank_ShouldReturnTrueForEmptyStrings(String input) {
        Assertions.assertTrue(Empty.isBlank(input));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        Assertions.assertEquals(expected, Empty.isBlank(input));
    }

    public static Stream<Arguments> argumentsForAdd(){
        return Stream.of(Arguments.of(1, 2, 3));

    }
    @ParameterizedTest
    @MethodSource("argumentsForAdd")
    void testAdd(int x, int b, int result){
        Assertions.assertEquals(result, x + b);
    }


    public static Stream<Arguments> argumentsForFormula(){
        return Stream.of(
                Arguments.of(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, 0),
                Arguments.of(5, 5, 5, 75),
                Arguments.of(6, 6, 6, 108 ),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3));
}

@ParameterizedTest
@MethodSource("argumentsForFormula")
    void testFormula(int a, int b, int c, long result){
        Assertions.assertEquals(result,  a*a + b*b + c*c);
}
}

