class MinStack {

    Node currentNode;
    
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int val) {
        if(currentNode == null) {
            Node newNode = new Node(val, val, null);
            currentNode = newNode;
        } else {
            Node newNode;
            if(val < currentNode.min) {
                newNode = new Node(val, val, currentNode);
            } else {
                newNode = new Node(val, currentNode.min, currentNode);
            }
            currentNode = newNode;
        }
    }
    
    public void pop() {
        if(currentNode != null) {
            Node temporaryNode = currentNode.previous;
            currentNode.previous = null;
            currentNode = temporaryNode;
        }
    }
    
    public int top() {
        if(currentNode != null) {
            return currentNode.val;
        }
        return -1;
    }
    
    public int getMin() {
        if(currentNode != null) {
            return currentNode.min;
        }
        return -1;
    }
    
    private class Node {
        
        int val;
        int min;
        Node previous;
        
        Node(int val, int min, Node previous) {
            this.val = val;
            this.min = min;
            this.previous = previous;
        }
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */