class MyHashSet {

    private int[] valueArray = new int[1000001];
    
    /** Initialize your data structure here. */
    public MyHashSet() {
    }
    
    public void add(int key) {
        valueArray[key] = 1;
    }
    
    public void remove(int key) {
        valueArray[key] = 0;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return valueArray[key] == 1;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */