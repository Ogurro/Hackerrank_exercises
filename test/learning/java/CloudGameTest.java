package learning.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CloudGameTest {

    private int[] c;
    private int expectedResult;

    public CloudGameTest(int[] c, int expectedResult) {
        this.c = c;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> inputParameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{0, 0, 1, 0, 0, 1, 0}, 4},
                {new int[]{0, 0, 0, 0, 1, 0}, 3},
                {new int[]{0, 1, 0, 0, 0, 1, 0}, 3},
                {new int[]{0, 0, 0, 1, 0, 0}, 3},
        });
    }

    @Test
    public void jumpingOnCloudsTest() {
        assertEquals(expectedResult, CloudGame.jumpingOnClouds(c));
    }

}
