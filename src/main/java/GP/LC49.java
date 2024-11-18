package GP;

import java.util.*;

public class LC49 {
    public static void main(String[] args) {
        LC49 sol = new LC49();
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
