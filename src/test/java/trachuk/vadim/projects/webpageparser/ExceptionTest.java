package trachuk.vadim.projects.webpageparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    @Test
    public void exceptionTest() throws Exception {
        try {
            throw new Exception("message1");
        } catch (Exception e) {
            try {
                throw new Exception("message3");
            } catch (Exception e3) {
                //do nothing
            }

            throw e ;

        } finally {
            try {
                throw new Exception("message2");
            } catch (Exception e2) {
                //do nothing
            }
        }
    }


    @Test
    public void exception2Test() throws Exception {
        try {
            int da = 5 / 0;
            try {
                if (false) {
                    throw new ArithmeticException("message1");
                }

            } catch (Exception e) {
                throw new Exception("message3");
            } finally {
                throw new Exception("message2");

            }
        } catch (Exception e) {
            Assertions.assertEquals("message1", e.getMessage());
        }
    }
}
