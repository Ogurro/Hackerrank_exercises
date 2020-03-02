package learning.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RepeatedStringTest {

    private String s;
    private long n;
    private long expectedResult;

    public RepeatedStringTest(String s, long n, long expectedResult) {
        this.s = s;
        this.n = n;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> inputParameters() {
        return Arrays.asList(new Object[][]{
                {"aba", 10L, 7L},
                {"a", 1000000000000L, 1000000000000L},
        });
    }

    @Test
    public void repeatedStringTest() {
        assertEquals(expectedResult, RepeatedString.repeatedString(s, n));
    }

}
