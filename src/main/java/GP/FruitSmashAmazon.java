package GP;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FruitSmashAmazon {

    public static int minFruitsLeft(int[] fruits) {
        // Step 1: Count the frequency of each fruit type
        Map<Integer, Integer> fruitCount = new HashMap<>();
        for (int fruit : fruits) {
            fruitCount.put(fruit, fruitCount.getOrDefault(fruit, 0) + 1);
        }

        // Step 2: Create a max-heap (priority queue) based on frequency
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(fruitCount.entrySet());

        // Step 3: Perform pairing using the top two elements
        while (maxHeap.size() > 1) {
            // Get the two most frequent fruit types
            Map.Entry<Integer, Integer> top1 = maxHeap.poll();
            Map.Entry<Integer, Integer> top2 = maxHeap.poll();

            // Reduce their counts by 1 (representing a "crush" operation)
            if (top1.getValue() > 1) {
                top1.setValue(top1.getValue() - 1);
                maxHeap.offer(top1);
            }
            if (top2.getValue() > 1) {
                top2.setValue(top2.getValue() - 1);
                maxHeap.offer(top2);
            }
        }

        // Step 4: Return the remaining count
        return maxHeap.isEmpty() ? 0 : maxHeap.poll().getValue();
    }

    public static void main(String[] args) {
        // Test Case 1: A = 8, B = 4, C = 2
        int[] fruits1 = {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3};
        System.out.println("Minimum fruits left: " + minFruitsLeft(fruits1)); // Expected: 2

        // Test Case 2: A = 8, B = 4, C = 1
        int[] fruits2 = {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3};
        System.out.println("Minimum fruits left: " + minFruitsLeft(fruits2)); // Expected: 3
    }
}
