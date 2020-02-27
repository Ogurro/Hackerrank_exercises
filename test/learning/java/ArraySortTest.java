package learning.java;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class ArraySortTest {

    private int[] arr;
    private int expectedResult;

    public ArraySortTest(int[] arr, int expectedResult) {
        this.arr = arr;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inputParameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{7, 1, 3, 2, 4, 5, 6}, 5},
                {new int[]{4, 3, 1, 2}, 3}
        });
    }

    @Test
    public void minimumSwapsTest() {
        assertEquals(expectedResult, ArraySort.minimumSwaps(arr));
    }
}
