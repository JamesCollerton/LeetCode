class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] uglyNumbers = new int[n];
        
        Queue<QueueItem> queue = new PriorityQueue<>((a, b) -> (a.currentNumber - b.currentNumber));
        
        for(int prime: primes) {
            queue.add(new QueueItem(prime, 1, prime));
        }
        
        uglyNumbers[0] = 1;
        
        for(int i = 1; i < n; i++) {
            uglyNumbers[i] = queue.peek().currentNumber;
            
            while(uglyNumbers[i] == queue.peek().currentNumber) {
                
                QueueItem queueItem = queue.poll();
                int newCurrentNumber = queueItem.beginningNumber * uglyNumbers[queueItem.currentIndexToMultiplyBy];
                int newCurrentIndexToMultiplyBy = queueItem.currentIndexToMultiplyBy + 1;
                queue.add(new QueueItem(newCurrentNumber, newCurrentIndexToMultiplyBy, queueItem.beginningNumber));
                
            }
        }
        
        return uglyNumbers[n - 1];
    }
    
    private class QueueItem {
        
        int currentNumber;
        int currentIndexToMultiplyBy;
        int beginningNumber;
        
        QueueItem(int currentNumber, int currentIndexToMultiplyBy, int beginningNumber) {
            this.currentNumber = currentNumber;
            this.currentIndexToMultiplyBy = currentIndexToMultiplyBy;
            this.beginningNumber = beginningNumber;
        }
        
    }
}