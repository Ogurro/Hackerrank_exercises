package learning.java;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TwoStringsTest {

    private String s1;
    private String s2;
    private boolean expectedResult;

    public TwoStringsTest(String s1, String s2, boolean expectedResult) {
        this.s1 = s1;
        this.s2 = s2;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inputParameters() {
        return Arrays.asList(new Object[][]{
                {"hello", "world", true},
                {"hi", "world", false}
        });
    }

    @Test
    public void commonSubstringTest() {
        assertEquals(expectedResult, TwoStrings.commonSubstring(s1, s2));
    }
}
