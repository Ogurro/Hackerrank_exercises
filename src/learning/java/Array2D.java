package learning.java;

public class Array2D {

    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr.length - 2; j++) {
                int value = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +             // 1st row
                            arr[i + 1][j + 1] +                                     // 2nd row
                            arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];  // 3rd row

                max = Math.max(value, max);
            }
        }

        return max;
    }
}
