package GP;

import java.util.HashMap;

public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int a:nums) {
            sum += a;
            if(map.containsKey(sum-k)) {
                result += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}
