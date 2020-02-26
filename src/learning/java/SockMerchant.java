package learning.java;
import java.util.*;
import java.util.stream.Collectors;

public class SockMerchant {

    static int countSocksPairs(int n, int[] ar) {

        int rv = 0;
        Set<Integer> arSet = Arrays.stream(ar).boxed().collect(Collectors.toSet());

        for (int color : arSet) {
            long sockCount = Arrays.stream(ar).filter(value -> value == color).count();
            rv += sockCount / 2;
        }
        return rv;
    }
}
