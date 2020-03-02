package learning.java;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class ValleysAndMountainsTest {

    private int n;
    private String s;
    private int expectedResult;

    public ValleysAndMountainsTest(int n, String s, int expectedResult) {
        this.n = n;
        this.s = s;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> inputParameters() {
        return Arrays.asList(new Object[][]{
                {8, "UDDDUDUU", 1},
                {12, "DDUUDDUDUUUD", 2},
        });
    }

    @Test
    public void countingValleysTest() {
        assertEquals(expectedResult, ValleysAndMountains.countingValleys(n, s));
    }

}
