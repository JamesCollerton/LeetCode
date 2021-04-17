import scala.collection.immutable.HashSet

/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

object Solution {
    def findDuplicateSubtrees(root: TreeNode): List[TreeNode] = {
        findDuplicateSubtreesStep(root.left, root.right, List[TreeNode]())
    }
    
    def findDuplicateSubtreesStep(
        node1: TreeNode, 
        node2: TreeNode, 
        duplicateList: List[TreeNode]
    ): List[TreeNode] = {
        
        if(node1 == null || node2 == null) {
            return duplicateList
        } 
        if(compareNodes(node1, node2) && !duplicateList.exists(node => compareNodes(node, node1))) {
            return duplicateList :+ node1
        }
        findDuplicateSubtreesStep(node1, node2.left, duplicateList) ++
        findDuplicateSubtreesStep(node1, node2.right, duplicateList) ++
        findDuplicateSubtreesStep(node1.left, node2, duplicateList) ++
        findDuplicateSubtreesStep(node1.right, node2, duplicateList)
    }
    
    def compareNodes(node1: TreeNode, node2: TreeNode): Boolean = {
        if(node1 == null && node2 == null) {
            true
        } else if(node1 == null || node2 == null) {
            false
        } else {
            node1.value == node2.value &&
            compareNodes(node1.left, node2.left) && 
            compareNodes(node1.right, node2.right)
        }
    }
    
    class TreeNodeWrapper(node: TreeNode) {
        
      override def equals(that: Any): Boolean =
        that match {
          case that: TreeNode => compareNodes(this, that)
          case _ => false
       }

      override def hashCode:Int = {
        val prime = 31
        var result = node.value.hashCode
        result = prime * result + age;
        result = prime * result + (if (name == null) 0 else name.hashCode)
        return result
      }
        
    }
}