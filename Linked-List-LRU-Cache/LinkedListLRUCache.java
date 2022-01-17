class LRUCache {

    private class ListNode {
        int value;
        int key;
        ListNode previous;
        ListNode next;
    }
    
    private Map<Integer, ListNode> cache = new HashMap<>();
    private int capacity;
    
    private ListNode head = new ListNode();
    private ListNode tail = new ListNode();
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        
        head.previous = null;
        tail.next = null;
        
        head.next = tail;
        tail.previous = head;
        
    }
    
    public int get(int key) {
        
        if(cache.containsKey(key)) {
            
            ListNode node = cache.get(key);
            
            removeNode(node);
            addNodeAtHead(node);
            
            return node.value;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(cache.containsKey(key)) {
            
            ListNode node = cache.get(key);
            node.value = value;
            removeNode(node);
            addNodeAtHead(node);
            
        } else {
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;

            addNodeAtHead(newNode);

            cache.put(key, newNode);

            if(cache.size() > capacity) {

                ListNode workingTail = tail.previous;
                removeNode(workingTail);
                cache.remove(workingTail.key);

            }
        }
                
    }
    
    private void removeNode(ListNode node) {
        
        ListNode previous = node.previous;
        ListNode next = node.next;

        previous.next = next;
        next.previous = previous;
        
        node.next = null;
        node.previous = null;
        
        // cache.remove(node.key);
        
    }
    
    private void addNodeAtHead(ListNode node) {
        
        node.previous = head;
        node.next = head.next;
        
        ListNode headNext = head.next;
            
        head.next.previous = node;
        head.next = node;
        
        // cache.put(node.key, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */