package learning.java;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public class ArrayRotationTest {

    private int[] a;
    private int d;
    private int[] expectedResult;

    public ArrayRotationTest(int[] a, int d, int[] expectedResult) {
        this.a = a;
        this.d = d;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inputParameters() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 5}, 4, new int[]{5, 1, 2, 3, 4}},
                {new int[]{1, 2, 3, 4, 5}, 5, new int[]{1, 2, 3, 4, 5}},
                {new int[]{1, 2, 3, 4, 5}, 9, new int[]{5, 1, 2, 3, 4}},
                {new int[]{1, 2, 3, 4, 5}, 10, new int[]{1, 2, 3, 4, 5}},
                {new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 26, new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5, 6}},

        });
    }

    @Test
    public void rotateLeftTest() {
        assertArrayEquals(expectedResult, ArrayRotation.rotateLeft(a, d));
    }
}
