class WordDictionary {

    private class Node {
        char c;
        List<Node> nodes = new ArrayList<>();
        boolean wordEnd = false;
        
        private Node() {
        }
        
        private Node(char c) {
            this.c = c;
        }
    }
    
    private Node root;
    
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        addNodeToTree(word.toCharArray(), 0, root);
    }
    
    private void addNodeToTree(char[] arr, int pointer, Node currentNode) {
        
        // Try and find the node in the tree, if the node exists then go down
        // a level and keep matching characters
        for(int i = 0; i < currentNode.nodes.size(); i++) {
            Node nextNode = currentNode.nodes.get(i);
            if(nextNode.c == arr[pointer]) {
                // If we're not at the end of our word
                if(pointer + 1 < arr.length) {
                    addNodeToTree(arr, pointer + 1, nextNode);
                // Otherwise need to add a marker this is the end of the word
                } else {
                    nextNode.wordEnd = true;
                }
                return;
            }
        }
        
        // Otherwise the node doesn't exist and we need to add it
        Node node = new Node(arr[pointer]);
        currentNode.nodes.add(node);
        if(pointer + 1 < arr.length) {
            addNodeToTree(arr, pointer + 1, node);
        } else {
            node.wordEnd = true;
        }
    }
    
    public boolean search(String word) {
        return findNode(word.toCharArray(), 0, root);
    }
    
    private boolean findNode(char[] arr, int pointer, Node currentNode) {
        
        // If we reached the end of the string then we've matched all
        // letters and we're good.
        if(pointer >= arr.length && currentNode.wordEnd) {
            return true;
        } else if(pointer >= arr.length) {
            return false;
        }
        
        boolean found = false;
        
        // If our current character is a . then we can go down to any of the next
        // levels
        if(arr[pointer] == '.') {
            for(int i = 0; i < currentNode.nodes.size(); i++) {
                // Keep searching as long as it's not found
                if(!found) {
                    found = found || findNode(arr, pointer + 1, currentNode.nodes.get(i));
                }
            }
        } else {
            for(int i = 0; i < currentNode.nodes.size(); i++) {
                if(currentNode.nodes.get(i).c == arr[pointer]) {
                    found = findNode(arr, pointer + 1, currentNode.nodes.get(i));
                }
            }
        }
        
        return found;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */