class Solution {
    
    private class ClassResult implements Comparable<ClassResult> {
        
        int pass;
        int total;
        double average;
        
        ClassResult(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.average = ((double) pass) / ((double) total);
        }
        
        @Override
        public int compareTo(ClassResult that) {
            
            double newThisAverage = ((double) (this.pass + 1)) / ((double) (this.total + 1));
            double newThatAverage = ((double) (that.pass + 1)) / ((double) (that.total + 1));
            
            double thisAverageDifference = newThisAverage - this.average;
            double thatAverageDifference = newThatAverage - that.average;
            
            if(thisAverageDifference > thatAverageDifference) {
                return - 1;
            } else if(thisAverageDifference < thatAverageDifference) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        Queue<ClassResult> queue = new PriorityQueue<>();
        
        for(int[] classResult: classes) {
            queue.offer(new ClassResult(classResult[0], classResult[1]));
        }
        
        for(int i = 0; i < extraStudents; i++) {
            ClassResult classResult = queue.poll();
            ClassResult newClassResult = new ClassResult(classResult.pass + 1, classResult.total + 1);
            queue.offer(newClassResult);
        }
        
        double result = 0;
        
        while(!queue.isEmpty()) {
            result += queue.poll().average;
        }
        
        return result / classes.length;
    }
}