package learning.java;

public class QueueBribe {

    static int minimumBribes(int[] q) {

        int bribes = 0;

        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] > (i + 3)) {
                return -1;
            }
            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                bribes += (q[j] > q[i]) ? 1 : 0;
            }
        }
        return bribes;
    }
}
