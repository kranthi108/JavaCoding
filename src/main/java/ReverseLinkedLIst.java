class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

class GfG {
    // Function to reverse the linked list
    static Node reverseList(Node head, int start, int end) {
        if(head == null || start>= end)
            return head;
        Node dummy = new Node(0);
        dummy.next = head;
        Node beforeStart = dummy;

        for(int i = 1; i< start; i++) {
            if(beforeStart == null) return head;
            beforeStart = beforeStart.next;
        }
        Node prev = null;
        Node current = beforeStart.next;
        Node tail = current;

        for( int i = start; i<= end; i++) {
            if(current == null) {
                System.out.println("kranthi");
                break;
            }
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        beforeStart.next = prev;
        tail.next = current;
        return dummy.next;
    }
    static Node reverseKNodes(Node head, int k) {
        if(head == null || k == 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prevEndofGroup = dummy;
        Node current = head;

        while(true) {
            Node prev = null;
            Node temp = current;

            Node kthNode = getKthNode(current, k);
            if(kthNode == null) {
                break;
            }
            Node groundEndnode = kthNode.next;

            for(int i = 0; i<k; i++) {
                Node next = temp.next;
                temp.next = prev;
                prev = temp;
                temp = next;
            }
            System.out.println(" kth Node" + kthNode.data + " Prev data" +  prev.data);
            prevEndofGroup.next = prev;
//            System.out.println("    " + kthNode.data);
            current.next = groundEndnode;
            prevEndofGroup = current;
            current = groundEndnode;
        }
        return dummy.next;
    }

    static Node getKthNode(Node node, int k) {
        while (node != null && k > 1) {
            node = node.next;
            k--;
        }
        return node;
    }
    // This function prints the contents 
    // of the linked list starting from the head
    static void printList(Node node) {
        while (node != null) {
            System.out.print(" " + node.data);
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        // 2 -> 1 -> 4 -> 3 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        System.out.print("Given Linked List:");
        printList(head);
        int start = 5;
        int end = 6;

//        head = reverseList(head, start, end);
        int k = 3;
        Node kNodeHead = reverseKNodes(head, k);
        System.out.print("\nReversed Linked List:");
//        printList(head);
        printList(kNodeHead);
    }
}