class Solution {
    
    ArrayList<String> seen = new ArrayList<String>();
    
    public int openLock(String[] deadends, String target) {
                
        int level = 0;
        List<Integer> initialSetting = List.of(0, 0, 0, 0);
        
        Queue<List<Integer>> queue = new LinkedList();
        queue.add(initialSetting);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            // Take all items off the queue at this level
            while(size != 0){
        
                size -= 1;
                
                List<Integer> currentQueueEntry = queue.remove();
                
                String currentSettingString = convertSettingToString(currentQueueEntry);

                // If we've already seen this then we know this route goes nowhere,
                // or if we're at a deadend the same applies
                if(!(
                    deadendsContainsSetting(deadends, currentSettingString) || 
                    seen.contains(currentSettingString)
                )){

                    seen.add(currentSettingString);

                    // We've found the solution, we want to return the level
                    // we're on
                    if(target.equals(currentSettingString)) {
                        return level; 
                    } else {
                        for(int i = 0; i < currentQueueEntry.size(); i++) {
                            List<Integer> oneStepForward = takeStep(i, 1, currentQueueEntry); 
                            queue.add(oneStepForward);
                            
                            // System.out.println("Here");

                            List<Integer> oneStepBack = takeStep(i, -1, currentQueueEntry);
                            queue.add(oneStepBack);
                            
                            // System.out.println("Here Again");
                        }
                    }
                }
            }
            
            level++;
            
        }
        
        return -1;

    }
    
    private List<Integer> takeStep(int position, int increment, List<Integer> currentSetting) {
        List<Integer> newList = new ArrayList<>(currentSetting);
        
        if(newList.get(position) + increment == 10) {
            newList.set(position, 0);
        } else if(newList.get(position) + increment == -1) {
            newList.set(position, 9);
        } else {
            newList.set(position, newList.get(position) + increment);
        }
        
        return newList;
    }
    
    private String convertSettingToString(List<Integer> currentSetting) {
        return currentSetting.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(""));
    }
    
    private boolean deadendsContainsSetting(String deadends[], String setting) {
        return Arrays.stream(deadends)
                    .filter(deadend -> setting.equals(deadend))
                    .findAny()
                    .isPresent();
    }
}