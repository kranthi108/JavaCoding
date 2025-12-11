package org.example;

//Your company is building a global compliance service for professional onboarding.
//Each country defines multiple rules, and some rules depend on others being evaluated first.
//Each rule is represented as an integer from 0 to N-1.
//Dependencies are given as pairs (a, b) meaning:
//Rule a must be executed before rule b.
//Task
//Write a program to determine a valid execution order of all rules.
//If no valid order exists (due to cycles in dependencies), return "INVALID".
//If multiple valid orders exist, return the one that is lexicographically smallest (i.e., always pick the smallest-numbered rule available first).


import java.util.*;

public class DependencyTask {

    public static void main(String[] args) {

        int[][] dependencies = {{1,0}, {2,0}, {3,1}, {3,2}}; // EXpected output { 3,1, 2, 0}
        int numberOfRules = dependencies.length;
//        List<Integer> restult = DependencyTask.findExecutionOrder(dependencies);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numberOfRules];
        for(int i = 0 ;i<numberOfRules; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] dependency: dependencies) {
            int dependentRule = dependency[0];
            int rule = dependency[1];
            graph.get(dependentRule).add(rule);
            inDegree[rule] = inDegree[rule]+1;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i<numberOfRules; i++ ) {
            if(inDegree[i] == 0) {
                priorityQueue.add(i);
            }
        }

        while (!priorityQueue.isEmpty()) {

        }
    }

}











