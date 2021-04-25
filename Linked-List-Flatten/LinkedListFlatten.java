/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        // If the list is empty, return null list         
        if(head == null) {
            return head;
        }
        
        // Otherwise put the pointer at the start
        Node pointer = head;
        
        // Flatten the first layer of the list. We can put the
        // end of the list pointing to null, as there is no
        // lower layer         
        flattenStep(pointer, null);
        
        // printList(head);
        
        return head;
    }
    
    private void flattenStep(Node pointer, Node previousParentNext) {
        
        // While there are still elements available at this layer of the list         
        while(pointer != null) {
            
            // If there is a child pointer
            if(pointer.child != null) {
                
                // Get the next element of this list, if it 
                // is null then it is the end of the list and
                // the child, not sure on expected behaviour
                Node next = pointer.next;
                
                // The pointer's next item should be its child,
                // the child should point back to this pointer,
                // We can move recursively up the chain and have
                // the end of the list point back to the next item
                Node child = pointer.child;
                pointer.next = child;
                child.prev = pointer;
                if(next != null) {
                    flattenStep(child, next);
                } else {
                    flattenStep(child, previousParentNext);
                }
                
                pointer.child = null;
                
                pointer = next;
            } else {
                
                // If we're at the end of this level of the list then we
                // need to link back to the item in the previous one.
                if(pointer.next == null) {
                    pointer.next = previousParentNext;
                    if(previousParentNext != null) {
                        previousParentNext.prev = pointer;
                    }
                    pointer = null;
                // If we're not then move on until we are
                } else {
                    pointer = pointer.next;
                }
                
            }
        }
    }
}