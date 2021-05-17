public class Stack {

    // This is an internal node class we use to implement a linked
    // list, which will act as our stack
    private class Node {
        private int val;
        private Node next;
        private Node(int val) {
            this.val = val;
        }
    }

    // In a stack we only need one pointer, which is the last
    // item that came in. This then points to the second last
    // item, which points to the third last item etc.
    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    // We return the value at the top of the stack
    public int peek() {
        if(top == null) {
            return -1;
        }
        return top.val;
    }

    // We add a new node at the top, linking it to the previous one
    public void push(int val) {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
    }

    // We remove the top node by moving the pointer along to the next
    // node. We temporarily store the old top node's value in order to
    // return it once it has been removed.
    public int remove() {
        if(top == null) {
            return -1;
        }

        int val = top.val;
        top = top.next;
        return val;
    }
}
