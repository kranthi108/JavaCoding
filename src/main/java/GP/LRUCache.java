package GP;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node() {

    }
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

}

public class LRUCache
{

    private static int capacity = 0;
    private static Map<Integer, Node> map;
    private static Node head;
    private static Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    static void moveTohead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    static int get(int key) throws Exception {
        Node node = map.get(key);
        if(node == null) {
            throw new Exception("dff");
        }
        moveTohead(node);

        return 1;
    }
    static boolean insertIntoCache(int key, int value) {
        Node node = map.get(key) ;
        if(node != null) {

            node.value = value;
            moveTohead(node);
        }
        else {
            Node node1 = new Node(key, value);
            map.put(key, node1);
            addToHead(node1);
            if(map.size() > capacity) {
                map.remove(tail.prev.key);
                removeNode(tail.prev);
            }
        }
        return true;
    }
    static void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    static void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public static void main(String[] args) {

    }
}