package trachuk.vadim.projects.parametrsTestExamples;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.Stream;

public class Examples {

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3,  17,  Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        Assertions.assertTrue(Examples.isOdd(number));
    }
////////////////////////////////////////


    public static boolean isOdd(String number) {
        return Integer.valueOf(number)  % 2 != 0;
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5", "-3", "17", "" + Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(String number) {
        Assertions.assertTrue(Examples.isOdd(number));
    }
//////////////////////////////////


    public static boolean isOdd(long number) {
        return number  % 2 != 0;
    }

    @ParameterizedTest
    @ValueSource(longs = {00000111, 5, 3, 17, 19, 15, Long.MAX_VALUE }) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(long number) {
        Assertions.assertTrue(Examples.isOdd(number));
    }
///////////////////////////////////////////////////////////////////////////////////////////



    public static boolean isOdd(byte number) {
        return number  % 2 != 0;
    }

    @ParameterizedTest
    @ValueSource(bytes = {00000111, 5, 3, 17, 19, 15, Byte.MAX_VALUE }) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(byte number) {
        Assertions.assertTrue(Examples.isOdd(number));
    }

/////////////////////////////////////////////////////////////////////////////////////////


    public static boolean isOdd(short number) {
        return number  % 2 != 0;
    }

    @ParameterizedTest
    @ValueSource(shorts = {00000111, 5, -3, 17, 19, 15, Short.MAX_VALUE }) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(short number) {
        Assertions.assertTrue(Examples.isOdd(number));
    }

/////////////////////////////////////////////////////////////////////////////////



    public static boolean isOdd(float number) {
        return number  % 2 != 0;
    }

    @ParameterizedTest
    @ValueSource(floats = {00000111, 5, 3, 17, 19.33f, 15,
    }) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(float number) {
        Assertions.assertTrue(Examples.isOdd(number));
    }



    ////////////////////////////////////////////////////



    public static boolean isOdd(double number) {
        return Double.valueOf(number).intValue() % 2 != 0;
    }

    @ParameterizedTest
    @ValueSource(doubles = {00000111, 5.7, 3, 17, 19.33f, 15,/*1.7976931348623157E307*/Double.MAX_VALUE }) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(double number) {
        Assertions.assertTrue(Examples.isOdd(number));
    }


    ///////////////////////////////////////////////////////////////////




}

