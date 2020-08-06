package trachuk.vadim.projects.parametrs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;


public class ParametrsTest {

    @Test
    public void callTest() {
        long a = 2;
        ArrayList<Long> arrayList = new ArrayList<>();

        arrayList.add(2L);

        test(a);
        Assertions.assertEquals(2, a);


        testArray(arrayList);
        Assertions.assertEquals(1, arrayList.size());
        Assertions.assertEquals(3 ,arrayList.get(0));
    }

    public void test(long a) {
        a = 3;
    }

    public void testArray(ArrayList<Long> arrayList) {
        arrayList.clear();
        arrayList.add(3L);

    }

}
