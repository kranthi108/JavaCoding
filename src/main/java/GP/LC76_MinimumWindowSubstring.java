package GP;

import java.util.HashMap;
import java.util.Map;

public class LC76_MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ABCCA", t = "AC";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
//        String res = "";
        int start = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if(map2.containsKey(c)) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
                if(map1.get(c).equals(map2.get(c))) {
                    valid++;
                }
            }
            while (valid == map2.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if(map2.containsKey(d)) {
                    if(map1.get(d).equals(map2.get(d))) {
                        valid--;
                    }
                    map1.put(d, map1.get(d) - 1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
