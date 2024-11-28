package GP;

import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class LC39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // dp[i] will store all combinations that sum up to 'i'
        List<List<Integer>>[] dp = new List[target + 1];

        // Base case: There is one way to make sum 0, that is by choosing no numbers.
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>()); // The empty combination for sum 0

        // Process each candidate number
        for (int c : candidates) {
            // Update the dp array for each sum from 'c' to 'target'
            for (int i = c; i <= target; i++) {
                if (dp[i - c] != null) { // If there are combinations that sum to i - c
                    for (List<Integer> comb : dp[i - c]) {
                        List<Integer> newComb = new ArrayList<>(comb);
                        newComb.add(c);  // Add current candidate to each combination
                        if (dp[i] == null) dp[i] = new ArrayList<>();
                        dp[i].add(newComb);  // Add the new combination to dp[i]
                    }
                }
            }
        }

        // Return all combinations for the target sum
        return dp[target] == null ? new ArrayList<>() : dp[target];
    }
}

//public class LC39_CombinationSum {
//    public static void main(String[] args) {
//        int[] input = {2,3,6,7};
//        int target = 7;
//        combinationSum(input, target);
//    }
//    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        runRecursion(candidates, target, 0, new ArrayList<>(), result);
//        return result;
//    }
//    public static void runRecursion(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> result) {
//        if(target == 0) {
//            result.add(new ArrayList<>(currentCombination));
//            return;
//        }
//        for (int i = start; i < candidates.length; i++) {
//            if(candidates[i] > target) continue;
//            currentCombination.add(candidates[i]);
//            runRecursion(candidates, target - candidates[i], i, currentCombination, result);
//            currentCombination.remove(currentCombination.size()-1);
//        }
//    }
//}


