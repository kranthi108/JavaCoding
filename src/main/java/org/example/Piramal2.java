//package org.example;
//
//class Node {
//    Node right;
//    Node left;
//    int data;
//
//    Node(int data) {
//        this.data = data;
//        this.right = null;
//        this.left = null;
//    }
//}
//public class Piramal2 {
//    public static void main(String[] args) {
//        // [1,2,3,5,6,1,3,2]
//        deleteNode(node);
//    }
//    static void deleteNode(Node node) {
//        if(node.right != null && node.left != null) {
//            node.left.right = node.right;
//            node.right.left = node.left;
//        }
//        else if(node.right == null)
//            node.left.right = null;
//        else {
//            head = node.right;
//            head.left =  null;
//
//        }
//    }
//}
