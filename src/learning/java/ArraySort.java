package learning.java;

public class ArraySort {

    static int minimumSwaps(int[] arr) {

        int i = 0;
        int swapCount = 0;

        while (i < arr.length) {
            if (arr[i] != (i + 1)) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                swapCount++;
            } else {
                i++;
            }
        }
        return swapCount;
    }
}
