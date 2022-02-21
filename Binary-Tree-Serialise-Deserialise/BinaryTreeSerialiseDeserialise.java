/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private final String SEPARATOR = "#";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "";
        }
        return serializeRecursion(root);
    }
    
    private String serializeRecursion(TreeNode node) {
        if(node == null) {
            return "";
        }
        String serialisation = Integer.toString(node.val);
        if(node.left != null) {
            serialisation += SEPARATOR + serializeRecursion(node.left);
        }
        if(node.right != null) {
            serialisation += SEPARATOR + serializeRecursion(node.right);
        }
        return serialisation;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(SEPARATOR);
        if("".equals(data) || nodes.length == 0) {
            return null;
        }
        pointer = 0;
        return deserializeRecursion(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);    
    }
    
    private int pointer;
    
    private TreeNode deserializeRecursion(String[] nodes, int min, int max) {
        
        TreeNode node = new TreeNode(Integer.valueOf(nodes[pointer]));
        
        pointer++;
        
        if(pointer < nodes.length) {
            int nextValue = Integer.valueOf(nodes[pointer]);

            if(nextValue < node.val && nextValue > min) {
                node.left = deserializeRecursion(nodes, min, node.val);
            }

            if(pointer < nodes.length) {
                nextValue = Integer.valueOf(nodes[pointer]);

                if(pointer < nodes.length && nextValue > node.val && nextValue < max) {
                    node.right = deserializeRecursion(nodes, node.val, max);
                }
            }
        }
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;