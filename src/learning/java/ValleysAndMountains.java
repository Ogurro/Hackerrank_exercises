package learning.java;

public class ValleysAndMountains {

    static int countingValleys(int n, String s) {

        int position = 0;
        boolean isInValley = false;
        int rv = 0;

        for (char c : s.toCharArray()) {
            position += ('U' == c) ? 1 : -1;
            if ((position < 0) && !isInValley) {
                isInValley = true;
                rv += 1;
            } else if ((position >= 0) && isInValley) {
                isInValley = false;
            }
        }

        return rv;
    }
}
