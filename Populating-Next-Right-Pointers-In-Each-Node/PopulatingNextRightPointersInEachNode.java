/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null) {
            return root;
        }
        
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                Node nextNode = queue.poll();
                if(size == 1) {
                    nextNode.next = null;
                } else {
                    nextNode.next = queue.peek();
                }
                if(nextNode.left != null) {
                    queue.add(nextNode.left);
                }
                if(nextNode.right != null) {
                    queue.add(nextNode.right);
                }
                size--;
            }
        }
        
        return root;
    }
}