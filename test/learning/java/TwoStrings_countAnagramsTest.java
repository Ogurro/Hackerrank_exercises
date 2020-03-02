package learning.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TwoStrings_countAnagramsTest {

    private String s;
    private int expectedResult;

    public TwoStrings_countAnagramsTest(String s, int expectedResult) {
        this.s = s;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> inputParameters() {
        return Arrays.asList(new Object[][]{
                {"abba", 4},
                {"abcd", 0},
                {"ifailuhkqq", 3},
                {"kkkk", 10}
        });
    }

    @Test
    public void commonSubstringTest() {
        assertEquals(expectedResult, TwoStrings.countAnagrams(s));
    }
}
