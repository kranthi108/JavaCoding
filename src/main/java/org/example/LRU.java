package org.example;

import java.util.HashMap;

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    private HashMap<Integer, Node> map;
    private int capacity, count;
    private Node head, tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        tail.next = null;
        head.prev = null;
        count = 0;
    }
    public void moveToHead(Node node) {
        node.next = head.next;
        head.next.prev = node; // reconsider
        node.prev = head;
        head.next = node;
    }

    public void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key) {
        if(map.get(key) != null) {
            Node node = map.get(key);
            int val = node.value;
            deleteNode(node);
            moveToHead(node);
            System.out.println("got the value for the key" + key + "value" + val);
            return val;
        }
        System.out.println("didnt find the value for the key");
        return -1;
    }
    public void set(int k, int v) {
        if(map.containsKey(k)) {
            Node node = map.get(k);
            node.value = v;
            deleteNode(node);
            moveToHead(node);
        }
        else {
            Node node = new Node(k, v);
            map.put(k, node);
            if(count < capacity) {
                moveToHead(node);
                count++;
            }
            else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                moveToHead(node);
            }
        }

    }
}

public class LRU{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        // it will store a key (1) with value
        // 10 in the cache.
        cache.set(1, 10);

        // it will store a key (1) with value 10 in the
        // cache.
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is "
                + cache.get(1)); // returns 10

        // evicts key 2 and store a key (3) with
        // value 30 in the cache.
        cache.set(3, 30);

        System.out.println(
                "Value for the key: 2 is "
                        + cache.get(2)); // returns -1 (not found)

        // evicts key 1 and store a key (4) with
        // value 40 in the cache.
        cache.set(4, 40);
        System.out.println(
                "Value for the key: 1 is "
                        + cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is "
                + cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is "
                + cache.get(4));

    }

}
