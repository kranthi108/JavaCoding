package GP;

import java.util.HashMap;

public class CountPairOfSimilarStrings {
    public static void main(String[] args) {
        similarPairs(new String[]{"abcc","abc", "abcd"});
    }
//    public static int similarPairs(String[] words) {
//        int ans = 0;
//        HashMap<Integer, Integer> freq = new HashMap();
//        for (var word : words) {
//            int mask = 0;
//            for (var ch : word.toCharArray())
//                mask |= 1<<ch-'a';
//            ans += freq.getOrDefault(mask, 0);
//            freq.merge(mask, 1, Integer::sum);
//        }
//        return ans;
//    }
    public static int similarPairs(String[] words) {
        int ans =0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(String word: words) {
            int mask = 0;
            for(char ch: word.toCharArray())
                mask |= 1<<ch-'a';
            ans += freq.getOrDefault(mask, 0);
            freq.merge(mask, 1, Integer::sum);
        }
        return ans;
    }
}
