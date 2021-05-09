class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Stack<String> result = new Stack<>();
        
        for(String word: words) {
                        
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
                                    
            // Look at the count of the current word
            int count = map.get(word);
            
            findPlaceInQueue(map, result, word, count, k);
            
        }
        
        return new ArrayList(result);
    }

    // We want to pop items off the queue as long
    // as their count is less than the current word
    // count (can ignore the current word if it's
    // on there). If their count is the same we want
    // to put them back on in alphabetical order. We
    // only want to add items back on as long as the
    // queue is less than size k
    private void findPlaceInQueue(
        HashMap<String, Integer> map, 
        Stack<String> result, 
        String currentWord, 
        int currentCount,
        int k
    ) {
        
        // If the stack is empty we can add the word as it
        // must have the highest frequency
        if(result.isEmpty()) {
            result.add(currentWord);
            return;
        }
        
        // Otherwise get the last word from the stack and
        // find how many times we have seen it.
        String poppedWord = result.pop();
        int poppedWordCount = map.get(poppedWord);
        
        // If we have seen the word coming in more often than the
        // one we have just popped off, then we need to keep popping
        // items off the queue to find a place
        if(currentCount > poppedWordCount) {
            
            // Keep popping items off queue to find the place
            findPlaceInQueue(map, result, currentWord, currentCount, k);
            
            // If we have not got enough results back in the queue then
            // we can add it back on. We also don't want to add the popped
            // word back on the queue if it's equal to the current word
            // as then we get repeats.
            if(result.size() < k && !currentWord.equals(poppedWord)) {
                result.push(poppedWord); 
            }
            
            return;
            
        // If the current count is equal to the popped word count we need to sort the
        // items so that they are in alphabetical order.
        } else if(currentCount == poppedWordCount) {
            
            // We need to sort these items
            
            // Popped word is lower in the alphabet, therefore
            // needs to come before current word in queue
            if(poppedWord.compareTo(currentWord) < 1) {
                                
                // Bubble up the popped word, we want to add the 
                findPlaceInQueue(map, result, poppedWord, poppedWordCount, k);
                                
                if(result.size() < k && !currentWord.equals(poppedWord)) {
                    result.push(currentWord); 
                }
                                
                return;
                
            } else if(poppedWord.compareTo(currentWord) == 0) {
                throw new RuntimeException("Duplicate word in queue with same count");
            } else {
                
                findPlaceInQueue(map, result, currentWord, currentCount, k);
                
                if(result.size() < k && !currentWord.equals(poppedWord)) {
                    result.push(poppedWord); 
                } 
                
                return;
            }
            
        } else if(currentCount < poppedWordCount) {
            // We can put this item on the queue as long
            // as the queue is less than k items long
            
            if(result.size() < k) {
                result.push(poppedWord); 
            }    
            
            if(result.size() < k && !currentWord.equals(poppedWord)) {
                result.push(currentWord); 
            }
            
            return;
        }
        
    }
}