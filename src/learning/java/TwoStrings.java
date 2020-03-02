package learning.java;

import java.util.*;

public class TwoStrings {

    public static boolean commonSubstring(String s1, String s2) {
        Set<String> s1Set = new HashSet<>(Arrays.asList(s1.split("")));
        Set<String> s2Set = new HashSet<>(Arrays.asList(s2.split("")));
        int sizeOfs1 = s1Set.size();
        s1Set.removeAll(s2Set);
        return (s1Set.size() != sizeOfs1);
    }
}
