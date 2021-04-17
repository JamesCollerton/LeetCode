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
            new TreeNodeWrapper(root.right),  
            new TreeNodeWrapper(root.left),  
            new TreeNodeWrapper(root.right),  
            List[TreeNodeWrapper]()
        )
        list.distinct.flatMap(generateSubTrees).distinct.map(_.node)
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
    
    def generateSubTrees(root: TreeNodeWrapper): List[TreeNodeWrapper] = {
        if(root.node == null) {
            return List[TreeNodeWrapper]()
        }
        return generateSubTrees(new TreeNodeWrapper(root.node.left)) ++ 
                generateSubTrees(new TreeNodeWrapper(root.node.left)) :+ 
                root
    }
    
    def findDuplicateSubtreesStep(
        nodeWrapperRootRightStart: TreeNodeWrapper,
        nodeWrapperLeft: TreeNodeWrapper,
        nodeWrapperRight: TreeNodeWrapper,
        list: List[TreeNodeWrapper]
    ): List[TreeNodeWrapper] = {
        
        // If we get to the bottom left then we want to stop as we'll have
        // been down the whole tree
        if(nodeWrapperLeft.node == null) {
            return list
        }
        
        // If we get to the bottom right then we want to move to the next
        // two items on the node wrapper left column
        if(nodeWrapperRight.node == null) {
            return list ++ 
                findDuplicateSubtreesStep(
                    nodeWrapperRootRightStart, 
                    new TreeNodeWrapper(nodeWrapperLeft.node.left), 
                    nodeWrapperRootRightStart,
                    list
                ) ++ 
                findDuplicateSubtreesStep(
                    nodeWrapperRootRightStart, 
                    new TreeNodeWrapper(nodeWrapperLeft.node.right), 
                    nodeWrapperRootRightStart,
                    list
                )
        }
        
        // If we've seen this node stop and return, doesn't matter which
        // node we add as they're equivalent
        if(nodeWrapperLeft == nodeWrapperRight) {
            return list :+ nodeWrapperLeft
        }
        
        // Otherwise we want to compare the left node with the next two right
        // nodes
        return list ++                 
                findDuplicateSubtreesStep(
                    nodeWrapperRootRightStart, 
                    nodeWrapperLeft, 
                    new TreeNodeWrapper(nodeWrapperRight.node.left),
                    list
                ) ++ 
                findDuplicateSubtreesStep(
                    nodeWrapperRootRightStart, 
                    nodeWrapperLeft,
                    new TreeNodeWrapper(nodeWrapperRight.node.right),
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