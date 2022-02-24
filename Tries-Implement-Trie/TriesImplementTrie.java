class Trie {

    private class Node {
        Character character;
        boolean end = false;
        Map<Character, Node> alphabetMap = new HashMap<>();
        
        Node(Character character) {
            this.character = character;
        }
    }
    
    private Node root;
    
    public Trie() {
        root = new Node('.');
    }
    
    public void insert(String word) {
        if(word == null || word.length() == 0) {
            return;
        }
        
        char[] charArr = word.toCharArray();
        recursivelyInsert(0, charArr, root);
    }
    
    private void recursivelyInsert(int pointer, char[] charArr, Node node) {
        if(pointer >= charArr.length) {
            return;
        }
        
        char nextChar = charArr[pointer];
        
        if(node.alphabetMap.containsKey(nextChar)) {
            if(pointer == charArr.length - 1) {
                node.alphabetMap.get(nextChar).end = true;
            } else {
                recursivelyInsert(pointer + 1, charArr, node.alphabetMap.get(nextChar));
            }
        } else {
            Node newNode = new Node(nextChar);
            node.alphabetMap.put(nextChar, newNode);
            if(pointer == charArr.length - 1) {
                newNode.end = true;
            } else {
                recursivelyInsert(pointer + 1, charArr, newNode);
            }
        }
    }
    
    public boolean search(String word) {
        if(word == null || word.length() == 0) {
            return false;
        }
        
        char[] charArr = word.toCharArray();
        Node endNode = recursivelyFindEndNode(0, charArr, root);
        return endNode == null ? false : endNode.end;
    }
    
    private Node recursivelyFindEndNode(int pointer, char[] charArr, Node node) {
        if(pointer >= charArr.length) {
            return null;
        }
        
        char nextChar = charArr[pointer];
        
        if(node.alphabetMap.containsKey(nextChar)) {
            if(pointer == charArr.length - 1) {
                return node.alphabetMap.get(nextChar);
            } else {
                return recursivelyFindEndNode(pointer + 1, charArr, node.alphabetMap.get(nextChar));
            }
        } else {
            return null;
        }
    }
    
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) {
            return false;
        }
        
        char[] charArr = prefix.toCharArray();
        Node endNode = recursivelyFindEndNode(0, charArr, root);
        return endNode != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */