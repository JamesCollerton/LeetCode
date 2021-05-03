class MyCircularQueue {
    
    private int head = -1;
    private int tail = -1;
    private int[] array;

    public MyCircularQueue(int k) {
        // Initialise an array of size k
        array = new int[k];
    }
    
    // We add an item onto the tail
    public boolean enQueue(int value) {
        
        // If we are currently at the end then
        // the tail should point back to the start
        if(tail == (array.length - 1)) {
            // If the head is currently at the start
            // then we can't add anything, so we return
            // false
            if(head == 0) {
                return false;
                
            // Otherwise we move the tail pointer back
            // to the start
            } else {
                tail = 0;
            }
        } else {
            
            // If the head is next then we can't add an
            // item as we would begin overwriting the tail
            if(head == tail + 1) {
                return false;
            } else {
                tail += 1;
            }
        }
        
        // If there is currently nothing in the queue both
        // the head and tail will be at -1, so now the head
        // and tail will be at the same spot
        if(head == -1) {
            head = 0;
        }
        
        array[tail] = value;
        return true;
    }
    
    // We delete the front element
    public boolean deQueue() {
        
        // If the head isn't pointing to anything we can't
        // dequeue
        if(head == -1) {
            return false;
        }
        
        // If head equals tail we've got a special case as we need
        // to set both of the pointers back to -1 as the queue is now
        // empty
        if(head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        
        // Otherwise we move head along. If it is at the end then we
        // move it back to the start
        if(head == (array.length - 1)) {
            head = 0;
        } else {
            head += 1;
        }
        
        return true;
    }
    
    // We return the value currently at head
    public int Front() {
        if(head == -1) {
            return -1;
        }
        return array[head];
    }
    
    // We return the value currently at the tail
    public int Rear() {
        if(tail == -1) {
            return -1;
        }
        return array[tail];
    }
    
    public boolean isEmpty() {
        return head == -1 && tail == -1;
    }
    
    public boolean isFull() {
        // If the tail is one before the head,
        // or if the tail is at the end and the
        // head is at the start, return true
        return (head == tail + 1) || (tail == (array.length - 1) && head == 0);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */