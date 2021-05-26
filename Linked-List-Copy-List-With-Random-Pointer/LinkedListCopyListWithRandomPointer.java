/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        Map<Node, Node> map = new HashMap<>();
        
        Node oldListNode = head;
        Node newListNodePrev = null;
        Node newListHead = null;
        
        while(oldListNode != null) {
            Node newListNode = new Node(oldListNode.val);
            if(newListNodePrev != null) {
                newListNodePrev.next = newListNode;
            } else {
                newListHead = newListNode;
            }
            map.put(oldListNode, newListNode);
            newListNodePrev = newListNode;
            oldListNode = oldListNode.next;
        }
        
        oldListNode = head;
        
        while(oldListNode != null) {
            if(oldListNode.random != null) {
                Node fromNode = map.get(oldListNode);
                Node toNode = map.get(oldListNode.random);
                fromNode.random = toNode;
            }
            oldListNode = oldListNode.next;
        }
        
        return newListHead;
    }
}