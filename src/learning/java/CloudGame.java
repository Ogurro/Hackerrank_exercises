package learning.java;

public class CloudGame {

    static int jumpingOnClouds(int[] c) {

        int jumpCount = 0;
        int position = 0;

        while (position < c.length - 1) {
            position += ((position + 2 != c.length) && (c[position + 2] == 0)) ? 2 : 1;
            jumpCount += 1;
        }

        return jumpCount;
    }
}
