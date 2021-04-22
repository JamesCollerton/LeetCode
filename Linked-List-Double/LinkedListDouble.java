class MyLinkedList {

    private LinkedListNode head;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        
        System.out.println("Getting at index " + index);
        printList();
        
        LinkedListNode node = getLinkedListNode(index);
        if(node != null) {
            System.out.println("Returning " + node.getValue());
            return node.getValue();
        }
        return -1;
    }
    
    private LinkedListNode getLinkedListNode(int index) {
        
        if(index < 0 || head == null) {
            return null;
        }
        
        LinkedListNode node = head;
        
        while(index > 0 && node != null) {
            node = node.getNextNode();
            index--;
        }
        
        return node;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        
        // System.out.println("Adding at head " + val);
        // printList();
        
        
        if(head == null) {
            head = new LinkedListNode(val, null, null);
        } else {
            LinkedListNode newNode = new LinkedListNode(val, head, null);
            head.setPreviousNode(newNode);
            head = newNode;
        }
        
        // printList();
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
        // System.out.println("Adding at tail " + val);
        // printList();
        
        if(head == null) {
            head = new LinkedListNode(val, null, null);
        }
        LinkedListNode node = head;
        while(node.getNextNode() != null) {
            node = node.getNextNode();
        }
        LinkedListNode newNode = new LinkedListNode(val, null, node);
        node.setNextNode(newNode);
        
        // printList();
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        // System.out.println("Adding at index " + index + " val " + val);
        // printList();
        
        if(index >= 0) { 
        
            if(index == 0) {
                addAtHead(val);
            }
            else {
                LinkedListNode listNode = getLinkedListNode(index - 1);
                // There's a node before the index we want, so putting in the middle
                if(listNode.getNextNode() != null) {
                    listNode = listNode.getNextNode();
                    LinkedListNode previousNode = listNode.getPreviousNode();
                    LinkedListNode newNode = new LinkedListNode(val, listNode, previousNode);
                    listNode.setPreviousNode(newNode);
                    if(previousNode != null) {
                        previousNode.setNextNode(newNode);
                    }
                } else {
                    addAtTail(val);
                }
            }
            
        }
        
        // printList();
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        
        // System.out.println("Deleting at index " + index);
        // printList();
        
        LinkedListNode listNode = getLinkedListNode(index);
        if(listNode!= null) {
            LinkedListNode previousNode = listNode.getPreviousNode();
            LinkedListNode nextNode = listNode.getNextNode();
            if(listNode.getPreviousNode() != null) {
                previousNode.setNextNode(nextNode);
            } else {
                head = nextNode;
            }
            if(nextNode != null) {
                nextNode.setPreviousNode(previousNode);
            }
            listNode.setNextNode(null);
            listNode.setPreviousNode(null);
        }
        
        // printList();
    }
    
    private void printList() {
        String list = "";
        LinkedListNode currNode = head;
        while(currNode != null) {
            list += "-" + currNode.getValue();
            currNode = currNode.getNextNode();
        }
        System.out.println("Current list " + list);
    }
}

class LinkedListNode {
    
    int value;
    LinkedListNode nextNode; 
    LinkedListNode previousNode;
    
    public LinkedListNode(int value, LinkedListNode nextNode, LinkedListNode previousNode) {
        this.value = value;
        this.nextNode = nextNode;
        this.previousNode = previousNode;
    }
    
    public int getValue() {
        return value;
    }
    
    public LinkedListNode getNextNode() {
        return nextNode;
    }
    
    public LinkedListNode getPreviousNode() {
        return previousNode;
    }
    
    public void setNextNode(LinkedListNode nextNode) {
        this.nextNode = nextNode;
    }
    
    public void setPreviousNode(LinkedListNode previousNode) {
        this.previousNode = previousNode;
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