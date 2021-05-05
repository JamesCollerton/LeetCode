class Solution {
    public int numSquares(int n) {        
        
        List<Integer> squares = squaresLessThanN(n);
        
        int level = 1;
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        squares.forEach(queue::add);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            while(size > 0) {
                                
                size--;
                
                Integer existingSum = queue.remove();
                
                if(existingSum == n) {
                    return level;
                } else if(existingSum < n) {
                    for(int i = 0; i < squares.size(); i++) {
                        int newSum = existingSum + squares.get(i);
                        if(!seen.contains(newSum)){
                            queue.add(newSum);
                        }
                        seen.add(newSum);
                    }
                }
                
            }
            
            level++;
        }
        
        return -1;
    }
    
    private List<Integer> squaresLessThanN(int n) {
        
        List<Integer> squares = new ArrayList<Integer>();
        
        int counter = 1;
        int currentSquare = 1;
            
        while(currentSquare <= n) {
            currentSquare = counter * counter;
            counter++;
            squares.add(currentSquare);
        }
        
        return squares;
    }
}