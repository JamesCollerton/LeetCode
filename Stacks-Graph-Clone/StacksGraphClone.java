/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    
    private HashMap<Node, Node> seenOriginalNodes = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        
        if(node == null) {
            return node;
        }
        
        return cloneNode(node);                
    }
    
    private Node cloneNode(Node node) {
                
        if(seenOriginalNodes.containsKey(node)) {
            return seenOriginalNodes.get(node);
        }
        
        Node newNode = new Node(node.val);
        seenOriginalNodes.put(node, newNode);
        
        ArrayList<Node> newNeighbors = new ArrayList<>();
        
        for(Node neighbor: node.neighbors) {
            newNeighbors.add(cloneNode(neighbor));
        }
        
        newNode.neighbors = newNeighbors;
        
        return newNode;
    }
}