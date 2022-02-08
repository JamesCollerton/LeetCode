import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'quickestWayUp' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY ladders
     *  2. 2D_INTEGER_ARRAY snakes
     */
     
    static class QueuePlace {
        int currentPosition;
        int numberMoves;
        QueuePlace(int currentPosition, int numberMoves) {
            this.currentPosition = currentPosition;
            this.numberMoves = numberMoves;
        }
    }

    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
    
        boolean canMove = true;
        boolean[] visited = new boolean[101];
        
        Map<Integer, Integer> laddersMap = new HashMap<>();
        Map<Integer, Integer> snakesMap = new HashMap<>();
        
        for(List<Integer> ladder: ladders) {
            laddersMap.put(ladder.get(0), ladder.get(1));
        }
        
        for(List<Integer> snake: snakes) {
            snakesMap.put(snake.get(0), snake.get(1));
        }
        
        Queue<QueuePlace> queue = new PriorityQueue<>((a, b) -> {
            return a.numberMoves - b.numberMoves;
        });
        queue.offer(new QueuePlace(1, 0));
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            
            QueuePlace queuePlace = queue.poll();
            
            int currentPosition = queuePlace.currentPosition;
            int numberMoves = queuePlace.numberMoves;
            
            visited[currentPosition] = true;
            
            for(int roll = 1; roll <= 6; roll++) {
                int newPosition = currentPosition + roll;
                
                if(laddersMap.containsKey(newPosition)) {
                    newPosition = laddersMap.get(newPosition);
                } else if(snakesMap.containsKey(newPosition)) {
                    newPosition = snakesMap.get(newPosition);
                }
                
                if(newPosition == 100) {
                    return numberMoves + 1;
                }
                
                if(!visited[newPosition]) {
                    queue.offer(new QueuePlace(newPosition, numberMoves + 1));
                }
            } 
            
        }

        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> ladders = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        ladders.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int m = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> snakes = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        snakes.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int result = Result.quickestWayUp(ladders, snakes);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
