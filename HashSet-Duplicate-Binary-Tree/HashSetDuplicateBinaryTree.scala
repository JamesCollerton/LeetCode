import scala.collection.immutable.HashMap

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
        val hashMap = findDuplicateSubtreesStep(
            new TreeNodeWrapper(root),  
            HashMap[TreeNodeWrapper, List[TreeNode]]()
        )
        hashMap.filter(kv => kv._2.length > 1).map(kv => kv._2(0)).toList
    }
    
    def findDuplicateSubtreesStep(
        nodeWrapper: TreeNodeWrapper,
        hashMap: HashMap[TreeNodeWrapper, List[TreeNode]]
    ): Map[TreeNodeWrapper, List[TreeNode]] = {
        
        // If we get to the bottom just return the HashMap         
        if(nodeWrapper.node == null) {
            return hashMap
        }
        
        // If we've seen this node stop and return
        if(hashMap.contains(nodeWrapper)) {
            return hashMap + (nodeWrapper -> (hashMap(nodeWrapper) :+ nodeWrapper.node))
        }
        
        val newHashMap = hashMap.get(nodeWrapper).map(list => {
            hashMap + (nodeWrapper -> (list :+ nodeWrapper.node))
            // Stop here
        }).getOrElse(
            hashMap + (nodeWrapper -> List(nodeWrapper.node))
        )
        
        val leftMap = findDuplicateSubtreesStep(
            new TreeNodeWrapper(nodeWrapper.node.left), 
            newHashMap
        )
        val rightMap = findDuplicateSubtreesStep(
            new TreeNodeWrapper(nodeWrapper.node.right), 
            newHashMap
        )
        
        val allKeys = leftMap.keySet ++ rightMap.keySet
        allKeys.map(key => {
            (
                key -> (
                    (leftMap.get(key).getOrElse(List[TreeNode]()) ++ 
                    rightMap.get(key).getOrElse(List[TreeNode]())).distinct
                )
            )
        }).toMap
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
    
    class TreeNodeWrapper(val node: TreeNode) {

        override def equals(that: Any): Boolean =
            that match {
              case that: TreeNodeWrapper => compareNodes(this.node, that.node)
              case _ => false
            }

        override def hashCode: Int = {
            if(node == null) {
                return 1
            }   
            val leftHashCode = new TreeNodeWrapper(node.left).hashCode() 
            val rightHashCode = new TreeNodeWrapper(node.right).hashCode() 
            node.value.hashCode() * leftHashCode * rightHashCode
        }

    }
    
}