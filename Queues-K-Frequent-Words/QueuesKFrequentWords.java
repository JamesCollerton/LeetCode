class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Queue<String> result = new LinkedList<>();
        
        // O(n)
        for(String word: words) {
            
            // Increment the count in the map O(1)
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
                                    
            // Look at the count of the current word
            int count = map.get(word);
            
            findPlaceInQueue(map, result, word, count, k);
        
        }
        
        return (List) result;
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
        Queue<String> result, 
        String currentWord, 
        int currentCount,
        int k
    ) {
        
        if(result.isEmpty()) {
            result.add(currentWord);
            return;
        }
        
        String poppedWord = result.remove();
        int poppedWordCount = map.get(poppedWord);
        
        if(currentCount > poppedWordCount) {
            // Keep popping items off queue to find the place
            findPlaceInQueue(map, result, currentWord, currentCount, k);
        } else if(currentCount == poppedWordCount) {
            // We need to sort these items
            
            // Popped word is lower in the alphabet, therefore
            // needs to come before current word in queue
            if(poppedWord.compareTo(currentWord) < 1) {
                
                findPlaceInQueue(map, result, poppedWord, poppedWordCount, k);
                
                if(result.size() < k) {
                    result.add(currentWord); 
                }
                
                return;
                
            } else if(poppedWord.compareTo(currentWord) == 0) {
                throw new RuntimeException("Duplicate word in queue");
            } else {
                
                findPlaceInQueue(map, result, currentWord, currentCount, k);
                
            }
            
            findPlaceInQueue(map, result, currentWord, currentCount, k);
            
        } else if(currentCount < poppedWordCount) {
            // We can put this item on the queue as long
            // as the queue is less than k items long
            if(result.size() < k) {
                result.add(currentWord); 
            }    
        }
        
        if(result.size() < k) {
            result.add(poppedWord); 
        }    
        
    }
}