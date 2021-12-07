class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        Arrays.sort(deck);
        
        for (int i = 0; i < deck.length / 2; i++) {
            int temp = deck[i];
            deck[i] = deck[deck.length - 1 - i];
            deck[deck.length - 1 - i] = temp;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < deck.length; i++) {
            
            if(!queue.isEmpty()) {
                int queueItem = queue.poll();
                queue.add(queueItem);
            }
            
            queue.add(deck[i]);
        }
        
        int[] result = new int[deck.length];
        int i = result.length - 1;
        
        while(!queue.isEmpty()) {
            result[i] = queue.poll();
            i--;
        }
        
        return result;
    }
}