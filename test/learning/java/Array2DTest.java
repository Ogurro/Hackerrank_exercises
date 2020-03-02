package learning.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Array2DTest {

    private int[][] arr;
    private int expectedResult;

    public Array2DTest(int[][] arr, int expectedResult) {
        this.arr = arr;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> inputParameters() {
        return Arrays.asList(new Object[][]{
                {new int[][]{
                        {1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 0},
                        {0, 0, 2, 4, 4, 0},
                        {0, 0, 0, 2, 0, 0},
                        {0, 0, 1, 2, 4, 0}}, 19},
                {new int[][]{
                        {-9, -9, -9, 1, 1, 1},
                        {0, -9, 0, 4, 3, 2},
                        {-9, -9, -9, 1, 2, 3},
                        {0, 0, 8, 6, 6, 0},
                        {0, 0, 0, -2, 0, 0},
                        {0, 0, 1, 2, 4, 0}}, 28},
        });
    }

    @Test
    public void hourglassSumTest() {
        assertEquals(expectedResult, Array2D.hourglassSum(arr));
    }

}
