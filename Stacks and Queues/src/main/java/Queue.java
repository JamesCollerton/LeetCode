public class Queue {

    // This is an internal node class we use to implement a linked
    // list, which will act as our queue
    private class Node {
        private int val;
        private Node next;
        private Node(int val) {
            this.val = val;
        }
    }

    // We need to track two pointers. One which looks at the head
    // of our list, one which looks at the tail. As this is a first
    // in first out structure we want to add at the tail, but take
    // from the head.
    private Node head;
    private Node tail;

    // If we have nothing to take, our queue is empty
    public boolean isEmpty() {
        return head == null;
    }

    // We return the value at the head of the queue
    public int peek() {
        if(head == null) {
            return -1;
        }
        return head.val;
    }

    // We want to add a new item to the tail of our queue.
    // We create a new node, and if we already have something
    // at the tail we put it on the end. If our head is null (the
    // list is empty) this is also our head.
    public void add(int val) {
        Node newNode = new Node(val);
        if(tail != null) {
            tail.next = newNode;
        }
        if(head == null){
            head = newNode;
        }
        tail = newNode;
    }

    // We want to get the value at the head and remove the current
    // head. The main thing we need to be aware of is that if we are
    // removing the last item in the list we need to set the head and
    // tail to null
    public int remove() {
        if(head == null) {
            return -1;
        }

        int val = head.val;

        head = head.next;

        if(head == null) {
            tail = null;
        }

        return val;
    }
}
