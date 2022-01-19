class Solution {
    public boolean canReach(int[] arr, int start) {
        
        Queue<Integer> queue = new LinkedList<>();
        // Could we mutate the current array to save space?
        // Set<Integer> seen = new HashSet<>();
        queue.offer(start);
        
        boolean found = false;
        
        while(!queue.isEmpty() && !found) {
            int currentPos = queue.poll();
            int currentJump = arr[currentPos];
            arr[currentPos] = -1;
            
            if(currentJump == 0) {
                found = true;
            } else {
                int posNewPos = currentPos + currentJump;
                if(posNewPos < arr.length && arr[posNewPos] != -1) {
                    queue.offer(posNewPos);
                }

                int negNewPos = currentPos - currentJump;
                if(negNewPos >= 0 && arr[negNewPos] != -1) {
                    queue.offer(negNewPos);
                }
            }
        }
        
        return found;
    }
}