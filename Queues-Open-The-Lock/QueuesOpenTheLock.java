class Solution {
    
    public int openLock(String[] deadends, String target) {
                
        int[] initialSetting = new int[]{0, 0, 0, 0};
        
        return checkAllCombos(deadends, initialSetting, target, new ArrayList<String>());

    }
    
    private int checkAllCombos(
        String deadends[], 
        int[] currentSetting, 
        String target, 
        List<String> seen
    ) {
        
        String currentSettingString = convertSettingToString(currentSetting);
        
        // If we've already seen this then we know this route goes nowhere,
        // or if we're at a deadend
        if(deadendsContainsSetting(deadends, currentSettingString) || 
           seen.contains(currentSettingString)){
            return -1;
        }
        
        seen.add(currentSettingString);
        
        // We've found the solution, we want to start counting up
        if(target.equals(currentSettingString)) {
            return 1;
        // We want to create a tree of all possible moves
        } else {
            for(int i = 0; i < currentSetting.length; i++) {
                
                int[] oneStepForwardArray = takeStep(i, 1, currentSetting);
                int oneStepForward = checkAllCombos(deadends, oneStepForwardArray, target, seen);
                
                // We've found a solution and we need to trace back
                // up counting the steps
                if(oneStepForward != -1) {
                    return oneStepForward + 1;    
                }
                
                int[] oneStepBackArray = takeStep(i, -1, currentSetting);
                int oneStepBack = checkAllCombos(deadends, oneStepBackArray, target, seen);
                
                // We've found a solution and we need to trace back
                // up counting the steps
                if(oneStepBack != -1) {
                    return oneStepBack + 1;    
                }
            }
            
            return -1;
        }
    }
    
    private int[] takeStep(int position, int increment, int[] currentSetting) {
        int[] newArray = Arrays.copyOf(currentSetting, currentSetting.length);
        
        if(newArray[position] + increment == 10) {
            newArray[position] = 0;
        } else if(newArray[position] + increment == -1) {
            newArray[position] = 9;
        } else {
            newArray[position] += increment;
        }
        
        return newArray;
    }
    
    private String convertSettingToString(int[] currentSetting) {
        return Arrays.stream(currentSetting)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(""));
    }
    
    private boolean deadendsContainsSetting(String deadends[], String setting) {
        return Arrays.stream(deadends)
                    .filter(deadend -> setting.equals(deadend))
                    .findAny()
                    .isPresent();
    }
}