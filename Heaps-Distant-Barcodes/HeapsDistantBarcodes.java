class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        
        Map<Integer, Integer> barcodeToCountMap = new HashMap<>();
        Set<Integer> barcodeSet = new HashSet<>();
        
        for(int barcode: barcodes) {
            barcodeToCountMap.put(barcode, barcodeToCountMap.getOrDefault(barcode, 0) + 1);
            barcodeSet.add(barcode);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> barcodeToCountMap.get(b) - barcodeToCountMap.get(a));
        
        for(int barcode: barcodeSet) {
            queue.offer(barcode);
        }
        
        int[] result = new int[barcodes.length];
        
        int i = 0;
        
        while(!queue.isEmpty()) {
            
            Integer nextBarcodeA = queue.poll();
            
            if(queue.isEmpty()) {
                
                result[i++] = nextBarcodeA;
                
                int barcodeACount = barcodeToCountMap.get(nextBarcodeA) - 1;

                barcodeToCountMap.put(nextBarcodeA, barcodeACount);

                if(barcodeACount > 0) {
                    queue.offer(nextBarcodeA);
                }
                
            } else {
                Integer nextBarcodeB = queue.poll();

                if(i > 0 && result[i - 1] == nextBarcodeA) {
                    result[i++] = nextBarcodeB;
                    result[i++] = nextBarcodeA;
                } else if(i > 0 && result[i - 1] == nextBarcodeB) {
                    result[i++] = nextBarcodeA;
                    result[i++] = nextBarcodeB;
                } else if(barcodeToCountMap.get(nextBarcodeA) > barcodeToCountMap.get(nextBarcodeB)) {
                    result[i++] = nextBarcodeA;
                    result[i++] = nextBarcodeB;
                } else if(barcodeToCountMap.get(nextBarcodeA) < barcodeToCountMap.get(nextBarcodeB)) {
                    result[i++] = nextBarcodeB;
                    result[i++] = nextBarcodeA;
                } else {
                    result[i++] = nextBarcodeA;
                    result[i++] = nextBarcodeB;                
                }

                int barcodeACount = barcodeToCountMap.get(nextBarcodeA) - 1;
                int barcodeBCount = barcodeToCountMap.get(nextBarcodeB) - 1;

                barcodeToCountMap.put(nextBarcodeA, barcodeACount);
                barcodeToCountMap.put(nextBarcodeB, barcodeBCount);

                if(barcodeACount > 0) {
                    queue.offer(nextBarcodeA);
                }
                if(barcodeBCount > 0) {
                    queue.offer(nextBarcodeB);
                }
            }
            
        }
        
        return result;
    }
}