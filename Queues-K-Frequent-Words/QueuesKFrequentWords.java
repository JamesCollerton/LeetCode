class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        Queue<String> result = new LinkedList<>();
        
        // O(n)
        for(String word: words) {
            
            System.out.println("");
            System.out.println("Word " + word);
            System.out.println("Current state of map");
            map.forEach((key, value) -> System.out.println(key + ":" + value));
            
            // Increment the count in the map O(1)
            if(map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
                                    
            // Look at the count of the current word
            int count = map.get(word);
            
            System.out.println("Current word count " + count);
            System.out.println("Finding place in queue");
            
            findPlaceInQueue(map, result, word, count, k);
            
            System.out.println("New queue");
            result.forEach(System.out::println);
        
        }
        
        List<String> toReturn = (List) result;
        Collections.reverse(toReturn);
        
        return toReturn;
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
        
        // If the queue is empty we can add the word as it
        // must have the highest frequency
        if(result.isEmpty()) {
            System.out.println("Detected queue as empty, adding word '" + currentWord + "'");
            result.add(currentWord);
            return;
        }
        
        // Otherwise get the last word from the queue and
        // find how many times we have seen it.
        String poppedWord = result.remove();
        int poppedWordCount = map.get(poppedWord);
        
        System.out.println("Last popped word '" + poppedWord + "'");
        System.out.println("Last popped word count: " + poppedWordCount);
        
        // If we have seen the word coming in more often than the
        // one we have just popped off, then we need to keep popping
        // items off the queue to find a place
        if(currentCount > poppedWordCount) {
            
            System.out.println("Detected current count " + currentCount + " greater than " + poppedWordCount);
            
            // Keep popping items off queue to find the place
            findPlaceInQueue(map, result, currentWord, currentCount, k);
            
            // If we have not got enough results back in the queue then
            // we can add it back on. We also don't want to add the popped
            // word back on the queue if it's equal to the current word
            // as then we get repeats.
            if(result.size() < k && !currentWord.equals(poppedWord)) {
                System.out.println("Result size small, adding back popped word '" + poppedWord + "'");
                result.add(poppedWord); 
            }
            
            return;
            
        // If the current count is equal to the popped word count we need to sort the
        // items so that they are in alphabetical order.
        } else if(currentCount == poppedWordCount) {
            
            // We need to sort these items
            System.out.println("Detected current count " + currentCount + " equal to " + poppedWordCount);
            
            // Popped word is lower in the alphabet, therefore
            // needs to come before current word in queue
            if(poppedWord.compareTo(currentWord) < 1) {
                
                System.out.println("Detected popped word '" + poppedWord + "' before '" + currentWord + "''");
                
                // Bubble up the popped word, we want to add the 
                findPlaceInQueue(map, result, poppedWord, poppedWordCount, k);
                
                System.out.println("Result size " + result.size());
                
                if(result.size() < k && !currentWord.equals(poppedWord)) {
                    System.out.println("Result size less than "+ k + ", adding current word '" + currentWord + "'");
                    result.add(currentWord); 
                }
                
                System.out.println("Returning after adding");
                
                return;
                
            } else if(poppedWord.compareTo(currentWord) == 0) {
                throw new RuntimeException("Duplicate word in queue with same count");
            } else {
                
                System.out.println("Detected popped word '" + poppedWord + "' after '" + currentWord + "'");
                
                findPlaceInQueue(map, result, currentWord, currentCount, k);
                
                System.out.println("Looking to readd popped word '" + poppedWord + "' current word '" + currentWord + "'");
                
                if(result.size() < k && !currentWord.equals(poppedWord)) {
                    System.out.println("Readding '" + poppedWord + "'");
                    result.add(poppedWord); 
                } 
                
                return;
            }
            
        } else if(currentCount < poppedWordCount) {
            // We can put this item on the queue as long
            // as the queue is less than k items long
            System.out.println("Current count " + " less than popped word count " + poppedWordCount);
            
            if(result.size() < k) {
                System.out.println("Adding back popped word '" + poppedWord + "'");
                result.add(poppedWord); 
            }    
            
            if(result.size() < k && !currentWord.equals(poppedWord)) {
                System.out.println("Adding back current word '" + poppedWord + "'");
                result.add(currentWord); 
            }
            
            return;
        }
        
    }
}