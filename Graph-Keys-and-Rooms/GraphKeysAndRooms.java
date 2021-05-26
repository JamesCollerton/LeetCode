class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> seen = new HashSet<Integer>();
        visitRoom(0, rooms, seen);
        return seen.size() == rooms.size();
    }
    
    private void visitRoom(int room, List<List<Integer>> rooms, Set<Integer> seen) {
        if(seen.contains(room)) {
            return;
        }
        seen.add(room);
        for(int newRoom: rooms.get(room)) {
            visitRoom(newRoom, rooms, seen);
        }
    }
}