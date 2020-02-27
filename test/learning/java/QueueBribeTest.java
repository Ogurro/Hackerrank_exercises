package learning.java;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import java.util.*;

@RunWith(Parameterized.class)
public class QueueBribeTest {

    private int[] q;
    private int expectedResult;

    public QueueBribeTest(int[] q, int expectedResult) {
        this.q = q;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inputParameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 1, 5, 3, 4}, 3},
                {new int[]{2, 5, 1, 3, 4}, -1},
                {new int[]{3, 2, 1, 4, 6, 5, 9, 7, 10, 8}, 7},
                {new int[]{3, 2, 1, 4, 6, 5, 7, 9, 8, 10}, 5}
        });
    }

    @Test
    public void minimumBribeTest() {
        assertEquals(expectedResult, QueueBribe.minimumBribes(q));
    }
}