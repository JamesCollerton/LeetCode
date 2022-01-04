class Solution {
    
    private int[] nums1;
    private int[] nums2;
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        Queue<Pair> queue = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        Set<List<Integer>> resultSet = new HashSet<>();
        this.nums1 = nums1;
        this.nums2 = nums2;
        
        queue.add(new Pair(0, 0));
        
        while(resultSet.size() < k && !queue.isEmpty()) {
            
            Pair pair = queue.poll();
            if(!resultSet.contains(List.of(pair.index1, pair.index2))) {
                resultSet.add(List.of(pair.index1, pair.index2));
                if(pair.index1 + 1 < nums1.length) {
                    queue.add(new Pair(pair.index1 + 1, pair.index2));
                }
                if(pair.index2 + 1 < nums2.length) {
                    queue.add(new Pair(pair.index1, pair.index2 + 1));
                }
            }
            
        }
        
        return resultSet.stream().map(l -> List.of(nums1[l.get(0)], nums2[l.get(1)])).collect(Collectors.toList());
    }
    
    private class Pair {
        
        int index1;
        int index2;
        int sum;
        
        Pair(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = nums1[index1] + nums2[index2];
        }
        
    }
}