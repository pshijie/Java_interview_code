package String;

import java.util.*;

/**
 * @author psj
 * @date 2022/9/16 10:55
 * @File: 字符串出现次数的TopK问题NC97.java
 * @Software: IntelliJ IDEA
 */
public class 字符串出现次数的TopK问题NC97 {
    public String[][] topKstrings(String[] strings, int k) {
        if (k == 0) {
            return new String[][]{};
        }
        String[][] result = new String[k][2];

        TreeMap<String, Integer> map = new TreeMap<>();
        for (String string : strings) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            } else {
                map.put(string, 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue()) == 0 ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i = 0; i < k; i++) {
            result[i][0] = list.get(i).getKey();
            result[i][1] = String.valueOf(list.get(i).getValue());
        }
        return result;
    }

}
