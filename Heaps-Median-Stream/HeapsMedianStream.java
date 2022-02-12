class MedianFinder {

    private Queue<Integer> smallestQueue;
    private Queue<Integer> largestQueue;
    private int size = 0;
    
    public MedianFinder() {
        smallestQueue = new PriorityQueue<>((a, b) -> b - a);
        largestQueue = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) { 
       if(smallestQueue.isEmpty()) {
            smallestQueue.offer(num);
        } else {
            if(num <= smallestQueue.peek()) {
                // Can simplify this logic
                if(smallestQueue.size() < largestQueue.size() + 1) {
                    smallestQueue.offer(num);
                } else {
                    largestQueue.offer(smallestQueue.poll());
                    smallestQueue.offer(num);
                }
            } else {
                if(smallestQueue.size() < largestQueue.size() + 1) {
                    if(num < largestQueue.peek()) {
                        smallestQueue.offer(num);
                    } else {
                        smallestQueue.offer(largestQueue.poll());
                        largestQueue.offer(num);
                    }
                } else {
                    largestQueue.offer(num);
                }
            }
       }
       size++;
    }
    
    public double findMedian() {
        if(size % 2 == 1) {
            return smallestQueue.peek();
        } else {
            return (smallestQueue.peek() + largestQueue.peek()) / 2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */