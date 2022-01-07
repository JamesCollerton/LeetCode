class Solution {
    
    private class Coordinates implements Comparable<Coordinates> {
        int x;
        int y;
        Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Coordinates that) {
            double thisDistance = Math.sqrt(this.x * this.x + this.y * this.y);
            double thatDistance = Math.sqrt(that.x * that.x + that.y * that.y);
            if(thisDistance < thatDistance) {
                return 1;
            }
            if(thisDistance > thatDistance) {
                return -1;
            }
            return 0;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        
        Queue<Coordinates> queue = new PriorityQueue<>();
        
        for(int[] point: points) {
            int x = point[0];
            int y = point[1];
            queue.offer(new Coordinates(x, y));
            if(queue.size() > k) {
                queue.poll();
            }
        }
        
        int[][] result = new int[k][2];
        
        for(int i = 0; i < k; i++) {
            Coordinates coordinates = queue.poll();
            result[i] = new int[]{coordinates.x, coordinates.y};
        }
            
        return result;
    }
}