import scala.collection.mutable.HashMap
import scala.collection.mutable.ListBuffer

/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

object Solution {
    
    var hashMap = HashMap[String, Integer]();
    var list = new ListBuffer[TreeNode]();
    
    def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {
        hashMap = HashMap[String, Integer]()
        list = new ListBuffer[TreeNode]()
        
        findDuplicateSubtreesStep(root)
        list.toList
    }
    
    def findDuplicateSubtreesStep(node: TreeNode): String = {
        
        if(node == null) {
            return "#"
        } else {
            
            val leftNodeValue = findDuplicateSubtreesStep(node.left)
            val rightNodeValue = findDuplicateSubtreesStep(node.right)
            
            val hash = node.value + "-" + leftNodeValue + "-" + rightNodeValue
                        
            if(hashMap.contains(hash)) {
                hashMap += (hash -> (hashMap(hash) + 1))
            } else {
                hashMap += (hash -> 1)
            }
            
            if(hashMap(hash) == 2) {
                list += node 
            }
            
            return hash
        }
    }
    
}