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
        
        val firstSplit = findFirstSplit(root)
        
        if(firstSplit == null) {
            return List[TreeNode]()
        }
        
        val list = findDuplicateSubtreesStep(
            firstSplit.right,  
            firstSplit.left,  
            firstSplit.right,  
            List[TreeNode]()
        )
        list.flatMap(generateSubTrees)
            .map(new TreeNodeWrapper(_))
            .distinct
            .map(_.node)
    }
    
    def findFirstSplit(root: TreeNode): TreeNode = {
        if(root == null) {
            return null
        } 
        if(root.left != null && root.right != null) {
            return root
        } 
        if(root.left == null) {
            return findFirstSplit(root.right)
        } 
        else {
            return findFirstSplit(root.left)
        }
    }
    
    def generateSubTrees(root: TreeNode): List[TreeNode] = {
        if(root == null) {
            return List[TreeNode]()
        }
        return generateSubTrees(root.left) ++ 
                generateSubTrees(root.right) :+ 
                root
    }
    
    def findDuplicateSubtreesStep(
        nodeRightStart: TreeNode,
        nodeLeft: TreeNode,
        nodeRight: TreeNode,
        list: List[TreeNode]
    ): List[TreeNode] = {
        
        // If we get to the bottom left then we want to stop as we'll have
        // been down the whole tree
        if(nodeLeft == null) {
            return list
        }
        
        // If we get to the bottom right then we want to move to the next
        // two items on the node wrapper left column
        if(nodeRight == null) {
            return list ++ 
                findDuplicateSubtreesStep(
                    nodeRightStart, 
                    nodeLeft.left, 
                    nodeRightStart,
                    list
                ) ++ 
                findDuplicateSubtreesStep(
                    nodeRightStart, 
                    nodeLeft.right, 
                    nodeRightStart,
                    list
                )
        }
        
        // If we've seen this node stop and return, doesn't matter which
        // node we add as they're equivalent
        if(compareNodes(nodeLeft, nodeRight)) {
            return list :+ nodeLeft
        }
        
        // Otherwise we want to compare the left node with the next two right
        // nodes
        return list ++                 
                findDuplicateSubtreesStep(
                    nodeRightStart, 
                    nodeLeft, 
                    nodeRight.left,
                    list
                ) ++ 
                findDuplicateSubtreesStep(
                    nodeRightStart, 
                    nodeLeft,
                    nodeRight.right,
                    list
                )
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