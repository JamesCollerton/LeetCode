class Solution {
        
    public int minMutation(String start, String end, String[] bank) {
        
        Set<String> bankSet = new HashSet<>();
        Set<String> seenSet = new HashSet<>();
        
        for(int i = 0; i < bank.length; i++) {
            bankSet.add(bank[i]);
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        
        int moves = 0;
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            while(size > 0) {
            
                String next = queue.remove();
                
                if(next.equals(end)) {
                    return moves;
                }
                    
                for(int i = 0; i < next.length(); i++) {
                    
                    for(char c: new char[]{'A', 'C', 'G', 'T'}) {
                        StringBuilder sb = new StringBuilder(next);
                        sb.setCharAt(i, c);
                        String string = sb.toString();

                        if(string != next && !seenSet.contains(string) && bankSet.contains(string)) {
                            queue.add(string);
                        }
                    }
                }
                
                seenSet.add(next);
                
                size--;
            }
            
            moves++;
        }
        
        return -1;
    }
    
}