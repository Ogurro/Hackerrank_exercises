package learning.java;

public class ArrayRotation {

    static int[] rotateLeft(int[] a, int d) {
        d = d % a.length;

        if (d == 0) {
            return a;
        }

        int[] rv = new int[a.length];
        System.arraycopy(a, d, rv, 0, (a.length - d));
        System.arraycopy(a, 0, rv, (a.length - d), d);

        return rv;
    }
}
