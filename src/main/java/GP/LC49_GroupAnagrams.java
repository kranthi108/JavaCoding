package GP;

import java.util.*;

public class LC49_GroupAnagrams {
    public static void main(String[] args) {
        LC49_GroupAnagrams sol = new LC49_GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = sol.groupAnagrams(strs);
        System.out.println(result);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupmap = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if(!groupmap.containsKey(sortedStr)) {
                groupmap.put(sortedStr, new ArrayList<>());

            }
            groupmap.get(sortedStr).add(s);
        }
        return new ArrayList<>(groupmap.values());
    }
}
