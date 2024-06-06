package utils

import model.TreeNode
import java.util.*

fun TreeNode?.levelPrint() {
    val array = mutableListOf<Int?>()
    val queue: Queue<TreeNode?> = LinkedList<TreeNode?>()
    this?.let {
        queue.offer(it)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node == null) {
                array.add(null);
                continue
            }
            array.add(node.`val`)
            queue.offer(node.left)
            queue.offer(node.right)
        }
    } ?: return
    print(array)
}

fun main() {
    val root = TreeNode(20);
    root.left = TreeNode(10)
    root.right = TreeNode(100).apply {
        left = TreeNode(4)
        right = TreeNode(100)
    }
    root.levelPrint()
}