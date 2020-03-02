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

    public static int countAnagrams(String s) {
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i + 1; j++) {
                char[] testSubstring = s.substring(j, j + i).toCharArray();
                Arrays.sort(testSubstring);
                for (int k = j + 1; k < s.length() - i + 1; k++) {
                    char[] checkSubstring = s.substring(k, k + i).toCharArray();
                    Arrays.sort(checkSubstring);
                    count += compareCharArrays(testSubstring, checkSubstring) ? 1 : 0;
                }
            }
        }
        return count;
    }

    private static boolean compareCharArrays(char[] c1, char[] c2) {
        if (c1.length != c2.length) {
            return false;
        }

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;

    }
}
