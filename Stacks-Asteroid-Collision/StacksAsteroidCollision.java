class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        List<Integer> result = new ArrayList<>();
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < asteroids.length; i++) {
            
            int currentAsteroid = asteroids[i];
            
            if(currentAsteroid > 0) {
                deque.addFirst(currentAsteroid);
            } else {
            
                boolean destroyed = false;
                int currentAsteroidSize = Math.abs(currentAsteroid);
                
                while(!destroyed && !deque.isEmpty() && deque.peekFirst() <= currentAsteroidSize) {
                    int destroyedAsteroidSize = deque.removeFirst();
                    destroyed = (destroyedAsteroidSize == currentAsteroidSize);
                }
                
                destroyed = destroyed || !(deque.isEmpty());
                
                if(!destroyed) {
                    result.add(currentAsteroid);
                }
            }
            
        }
        
        while(!deque.isEmpty()) {
            result.add(deque.removeLast());
        }
        
        int[] array = new int[result.size()];
        for(int i = 0; i < result.size(); i++) array[i] = result.get(i);
        
        return array;
    }
}