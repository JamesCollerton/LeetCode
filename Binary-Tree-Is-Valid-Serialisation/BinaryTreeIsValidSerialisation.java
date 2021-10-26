class Solution {
    public boolean isValidSerialization(String preorder) {
        List<String> nodes = new ArrayList<>(Arrays.asList(preorder.split(",")));
        return recurse(nodes) && nodes.isEmpty();
    }
    
    private boolean recurse(List<String> nodes) {
        if(nodes.isEmpty()) {
            return false;
        }
        if("#".equals(nodes.get(0))) {
            nodes.remove(0);
            return true;
        }
        
        nodes.remove(0);
        return recurse(nodes) && recurse(nodes);
    }
}