class Solution {
    public boolean isPossible(int[] nums) {
        
        Queue<Stack<Integer>> queue = new PriorityQueue<>((a, b) -> {
            if(a.peek() < b.peek()) {
                return -1;
            } else if(a.peek() > b.peek()) {
                return 1;
            } else {
                return a.size() - b.size();
            }
        });
        
        for(int num: nums) {
            
            while(!queue.isEmpty() && queue.peek().peek() < num - 1) {
                if(queue.poll().size() < 3) {
                    return false;
                }
            }
            
            Stack<Integer> stack;
            if(!queue.isEmpty() && queue.peek().peek() == num - 1) {
                stack = queue.poll();
            } else{
                stack = new Stack<>();
            }
            stack.push(num);
            queue.offer(stack);
        }
                
        while(!queue.isEmpty()) {
            if(queue.poll().size() < 3) {
                return false;
            }
        }
        
        return true;
    }
}