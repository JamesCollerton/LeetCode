class Solution {
    
    private class Node {
        int person;
        int group = 0;
        Node(int person) {
            this.person = person;
        }
    }
    
    private boolean isPossible = true;
    private Map<Node, List<Node>> graph = new HashMap<>();    
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<Node> nodeList = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            Node node = new Node(i);
            graph.put(node, new ArrayList<>());
            nodeList.add(node);
        }
        
        for(int[] dislike: dislikes) {
            int personA = dislike[0];
            int personB = dislike[1];
            Node personANode = nodeList.get(personA);
            Node personBNode = nodeList.get(personB);
            graph.get(personANode).add(personBNode);
            graph.get(personBNode).add(personANode);
        } 
        
        for(Node node: graph.keySet()) {
            if(isPossible && node.group == 0) {
                dfs(node, 1);
            }
        }
        
        return isPossible;
    }
    
    private void dfs(Node currentNode, int currentGroup) {
        
        if(currentNode.group != 0) {
            if(currentNode.group != currentGroup) {
                isPossible = false;
            }
            return;
        }
        
        currentNode.group = currentGroup;
        
        for(Node node: graph.get(currentNode)) {
            int newGroup = currentGroup == 1 ? 2 : 1;
            dfs(node, newGroup);
        }
        
    }
}