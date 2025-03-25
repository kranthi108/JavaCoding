package GP;

/**
 * Solution for LeetCode 3318: X-Sum
 * Time Complexity: O(n) where n is the length of the input array
 *   - Using a priority queue to maintain top elements in O(log k) time per operation
 *
 * Space Complexity: O(k) where k is the window size
 *   - O(k) for the frequency map and priority queue
 */
import java.util.*;

public class XsumKLong {
    public static void main(String[] args) {
        int[] input = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6;
        int x = 2;
        int[] result = findXSum(input, k, x);
        for (int val : result) {
            System.out.println(val);
        }
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        if(nums == null || nums.length < k || x < 1) {
            return new int[0];
        }
        int[] result = new int[nums.length-k+1];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i = 0; i < k; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) +1);
        }
        for( int i=0; i<=nums.length-k; i++) {
            result[i] = calculateXsum(freqMap, x);
            if (i < nums.length -k) {
                freqMap.put(nums[i+k], freqMap.getOrDefault(nums[i+k], 0)+1);
                freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0)-1);
                if(freqMap.get(nums[i]) == 0) {
                    freqMap.remove(nums[i]);
                }
            }

        }
        return result;
        // Process each window
    }
    public static int calculateXsum(Map<Integer, Integer> freqMap, int x) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b) ->
                    a.getValue().equals(b.getValue())
                            ?  b.getKey() - a.getKey()
                            :  b.getValue() - a.getValue()
                );
        pq.addAll(freqMap.entrySet());
        int sum = 0;
        int count = 0;
        while(!pq.isEmpty() && count < x) {
            Map.Entry<Integer, Integer> i = pq.poll();
            sum += i.getKey()*i.getValue();
            count++;
        }
        return sum;
    }

//    private static int calculateXSum(Map<Integer, Integer> freqMap, int x) {
//        // Use a priority queue to track top x elements
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
//                (a, b) -> {
//                    if (a.getValue().equals(b.getValue())) {
//                        return b.getKey() - a.getKey();
//                    }
//                    return b.getValue() - a.getValue();
//                }
//        );
//
//        // Add all entries to the priority queue
//        pq.addAll(freqMap.entrySet());
//
//        int sum = 0;
//        int count = 0;
//
//        // Take top x elements
//        while (!pq.isEmpty() && count < x) {
//            Map.Entry<Integer, Integer> entry = pq.poll();
//            sum += entry.getKey() * entry.getValue();
//            count++;
//        }
//
//        return sum;
//    }
}