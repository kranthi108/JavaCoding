package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node1 {
    Node1 right;
    Node1 left;
    int data;

    Node1(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

public class Piramal {
    public static HashMap<Node1, Integer> resultMap = new HashMap<>();
    public static void main(String[] args) {
        Node1 root = new Node1(1);
        root.left = new Node1(7);
        root.right = new Node1(9);
        root.left.left = new Node1(2);
        root.left.right = new Node1(6);
        root.left.right.left = new Node1(5);
        root.left.right.right = new Node1(11);
        root.right.right = new Node1(9);

        Node1 firstNode = root.left.left;
        Node1 secondNode = root.left.right;
        findCousins(root, firstNode, secondNode, 0);
        if(whetherCousins()){
            System.out.println("YES");
        }
        else
            System.out.println("NO");
    }
    public static boolean whetherCousins(){
        if(resultMap.size() != 2){
            return false;
        }
        Node1 parent1, parent2;
        int level1, level2;
        List<Map.Entry<Node1,Integer>> list = new ArrayList<>();
        for(Map.Entry<Node1, Integer> a : resultMap.entrySet()) {
            list.add(a);
        }
        parent1 = list.get(0).getKey();
        parent2 = list.get(1).getKey();
        level1 = list.get(0).getValue();
        level2 = list.get(1).getValue();
        if(level2==level1 && parent2 != parent1)
            return  true;
        return false;
    }
    public static void findCousins(Node1 root, Node1 first, Node1 second, int level) {
        if(root == null) {
            return;
        }
        if(root.left == first || root.right == first){
            resultMap.put(root, level );

        }
        if(root.left == second || root.right == second){
            resultMap.put(root, level );
        }
        findCousins(root.left, first, second,level+1);
        findCousins(root.right, first, second, level+1);
    }
}
