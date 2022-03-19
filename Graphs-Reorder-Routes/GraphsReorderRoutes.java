class Solution {
    public int minReorder(int n, int[][] connections) {
        
        int count = 0;
        
        Set<Integer> seen = new HashSet<>();
        
        Map<Integer, List<Integer>> fromToNodes = new HashMap<>();
        Map<Integer, List<Integer>> toFromNodes = new HashMap<>();
        
        for(int[] connection: connections) {
            int from = connection[0];
            int to = connection[1];
            
            List<Integer> fromToList = fromToNodes.getOrDefault(from, new LinkedList<>());
            fromToList.add(to);
            
            List<Integer> toFromList = toFromNodes.getOrDefault(to, new LinkedList<>());
            toFromList.add(from);
            
            fromToNodes.put(from, fromToList);
            toFromNodes.put(to, toFromList);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        seen.add(0);
        
        while(!queue.isEmpty()) {
            
            int node = queue.poll();
            
            if(fromToNodes.containsKey(node)) {

                for(int nodeCanGetTo: fromToNodes.get(node)) {
                    if(!seen.contains(nodeCanGetTo)) {
                        seen.add(nodeCanGetTo);
                        count++;
                        queue.offer(nodeCanGetTo);
                    }
                }

            } 

            if(toFromNodes.containsKey(node)) {

                for(int nodeCanGetFrom: toFromNodes.get(node)) {
                    if(!seen.contains(nodeCanGetFrom)) {
                        seen.add(nodeCanGetFrom);
                        queue.offer(nodeCanGetFrom);
                    }
                }

            }
                
        }
        
        return count;
    }
}