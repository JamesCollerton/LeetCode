class Solution {
    
    // [1, 2, 1, 1, 3, 2, 4]
    // 1 -> 3
    // 2 -> 2
    // 3 -> 1
    // 4 -> 1
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        Map<Integer, Integer> barcodeToCountMap = new HashMap<>();
        
        for(int barcode: barcodes) {
            barcodeToCountMap.put(barcode, barcodeToCountMap.getOrDefault(barcode, 0) + 1);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> barcodeToCountMap.get(b) - barcodeToCountMap.get(a));
        queue.addAll(barcodeToCountMap.keySet());
        
        int[] result = new int[barcodes.length];
        int index = 0;
                
        while(!queue.isEmpty()) {
            
            int barcode = queue.poll();
            int count = barcodeToCountMap.get(barcode);
            
            while(count > 0) {
                result[index] = barcode;
                index += 2;
                index = index >= result.length ? 1 : index;
                count--;
            }
            
        }
        
        return result;
    }
}