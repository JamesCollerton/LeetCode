class Solution {
    
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
                
        Map<Integer, List<Integer>> graph = new HashMap<>();
                
        for(int i = 0; i < prerequisites.length; i++) {
            
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            
            if(graph.containsKey(prerequisites[i][0])) {
                graph.get(course).add(prerequisite);
            } else {
                List<Integer> prerequisitesList = new ArrayList<>();
                prerequisitesList.add(prerequisite);
                graph.put(course, prerequisitesList);
            }
        }
                
        for(Integer courseWithPrerequisites: graph.keySet()) {
            if(!visited.contains(courseWithPrerequisites)) {
                if(cycleFound(graph, courseWithPrerequisites, new HashSet<>())) {
                    return false;
                }         
            }
        }
                
        return true;
    }
    
    private boolean cycleFound(Map<Integer, List<Integer>> graph, int currentCourse, Set<Integer> seen) {
        
        // No prerequisites for course means we can't have a loop
        if(visited.contains(currentCourse) || !graph.containsKey(currentCourse)) {
            return false;
        }
        
        // If we've already seen this course then we have a loop
        if(seen.contains(currentCourse)) {
            return true;
        }
        
        seen.add(currentCourse);
        
        List<Integer> adjacent = graph.get(currentCourse);
        
        for(int i = 0; i < adjacent.size(); i++) {
            if(cycleFound(graph, adjacent.get(i), new HashSet<>(seen))) {
                return true;
            }
        }
        
        visited.add(currentCourse);
        
        return false;
    }
}