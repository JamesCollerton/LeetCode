class MyLinkedList {

    private LinkedListNode head;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        
        // System.out.println("Getting node at index " + index);
        
        LinkedListNode node = getNodeAtIndex(index);
        
        int value;
        if(node != null) {
            value = node.getValue();
        } else {
            value = -1;
        }
        
        // System.out.println("Got value " + value);
        
        return value;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        
        // System.out.println("Adding value at head " + val);
        
        LinkedListNode newHead = new LinkedListNode(val, head);
        this.head = newHead;
        
        // printList();
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
        // System.out.println("Adding value at tail " + val);
        
        LinkedListNode currentNode = head;
        
        // Nothing in the list, add a new head         
        if(currentNode == null) {
            this.head = new LinkedListNode(val, null);
        } else {
            // Get last element of the list             
            while(currentNode.getNextNode() != null) {
                // System.out.println("In loop value " + currentNode.getValue());
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(new LinkedListNode(val, null));
        }
        
        // printList();
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        // System.out.println("Adding value " + val + " at index " + index);
        
        if(index < 0) {
            return;
        }
        
        if(index == 0) {
            addAtHead(val);
        }
        
        LinkedListNode previousNode = getNodeAtIndex(index - 1);
        
        if(previousNode == null) {
            return;
        }
        
        LinkedListNode node = getNodeAtIndex(index);
        
        if(node == null) {
            // return;
            addAtTail(val);
        } else {
            LinkedListNode newNode = new LinkedListNode(val, node);
            previousNode.setNextNode(newNode);
        }
        
        // printList();
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        
        // System.out.println("Deleting value at index " + index);
        
        if(index < 0) {
            return;
        }
        
        if(index == 0) {
            if(head != null) {
                this.head = head.getNextNode();
            }
        }
        
        LinkedListNode previousNode = getNodeAtIndex(index - 1);
        
        if(previousNode == null) {
            return;
        }
        
        LinkedListNode node = getNodeAtIndex(index);
        
        if(node == null) {
            return;
        }
        
        previousNode.setNextNode(node.getNextNode());
        node.setNextNode(null);
        
        // printList();
    }
    
    private LinkedListNode getNodeAtIndex(int index) {
        
        // System.out.println("Getting node at index " + index);
        // printList();
        
        if(index <= -1) {
            return null;
        }
        
        LinkedListNode currentNode = head;
        
        while(index > 0) {
            if(currentNode == null) {
                return null;
            }
            
            index--;
            
            currentNode = currentNode.getNextNode();
            
            // System.out.println("In loops index " + index + " value " + currentNode.getValue());
        }
        
        // System.out.println("Got node with value " + currentNode.getValue());
        
        return currentNode;
    }
    
    private void printList() {
        String list = "";
        LinkedListNode currNode = head;
        while(currNode != null) {
            list += "-" + currNode.getValue();
            currNode = currNode.getNextNode();
        }
        System.out.println(list);
    }
}

class LinkedListNode {
    
    int value;
    LinkedListNode nextNode; 
    
    public LinkedListNode(int value, LinkedListNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }
    
    public int getValue() {
        return value;
    }
    
    public LinkedListNode getNextNode() {
        return nextNode;
    }
    
    public void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }
    
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */