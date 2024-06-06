package lp

import model.TreeNode
import utils.levelPrint

//某二叉树的先序遍历结果记录于整数数组 preorder，它的中序遍历结果记录于整数数组 inorder。请根据 preorder 和 inorder 的提示
//构造出这棵二叉树并返回其根节点。 
//
// 
//
// 注意：preorder 和 inorder 中均不含重复数字。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//
//输出: [3,9,20,null,null,15,7]
// 
//
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
//
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1130 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */


class Solution124 {
    fun deduceTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null;
        }
        val rootVal = preorder[0]
        val rootNode = TreeNode(preorder[0]);
        val rootIndexInOrder = inorder.indexOf(rootVal);
        rootNode.left = deduceTree(
            preorder.sliceArray(1..<rootIndexInOrder + 1),
            inorder.sliceArray(0..<rootIndexInOrder)
        )
        rootNode.right = deduceTree(
            preorder.sliceArray(rootIndexInOrder + 1..<preorder.size),
            inorder.sliceArray(rootIndexInOrder + 1..<inorder.size)
        )
        return rootNode
    }
}

fun main() {
    val preOrder = intArrayOf(3, 9, 20, 15, 7)
    val inOrder = intArrayOf(9, 3, 15, 20, 7)
    Solution124().deduceTree(preOrder, inOrder).levelPrint()
}
//leetcode submit region end(Prohibit modification and deletion)
