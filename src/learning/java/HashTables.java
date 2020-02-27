package learning.java;

import java.util.HashMap;
import java.util.Map;

public class HashTables {

    static boolean checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> magazineMap = new HashMap<>();

        for (String key : magazine) {
            int val = magazineMap.getOrDefault(key, 0);
            magazineMap.put(key, (val + 1));
        }

        for (String key : note){
            if (!magazineMap.containsKey(key)) {
                return false;
            } else {
                int val = magazineMap.get(key) - 1;
                if (val >= 0) {
                    magazineMap.replace(key, val);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
