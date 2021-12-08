class Solution {
    public int findTheWinner(int n, int k) {
        
        List<Integer> players = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            players.add(i);
        }
        
        int position = 0;
        while(players.size() > 1) {
            position = (position + k - 1) % players.size();
            players.remove(position);
            if(position > players.size()) {
                position = 0;
            }
        }
        
        return players.get(0);
    }
}