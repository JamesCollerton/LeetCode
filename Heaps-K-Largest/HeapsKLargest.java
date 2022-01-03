class KthLargest {

    Queue<Integer> queue;
    int k;
    
    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        this.k = k;
        for(int i: nums) {
            queue.add(i);
        }
        while(queue.size() > k) {
            queue.remove();
        }
    }
    
    public int add(int val) {
        queue.add(val);
        if(queue.size() > k) {
            queue.remove();
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */