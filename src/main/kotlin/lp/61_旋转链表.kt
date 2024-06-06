package lp

class Solution61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var vk = k
        if (head == null) {
            return null
        }
        if (vk < 1) {
            return head
        }
        var fast: ListNode? = head
        var slow: ListNode? = head
        var length = 0
        while (fast != null) {
            length++
            fast = fast.next;
        }
        vk %= length
        fast = head
        repeat(vk) {
            fast = fast?.next
        }
        while (fast?.next != null) {
            fast = fast?.next
            slow = slow?.next
        }
        val node = slow?.next ?: return head
        slow.next = null
        fast?.next = head
        return node
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val head = ListNode(1).also { it.next = ListNode(2).also { it.next = ListNode(3) } }
    Solution61().rotateRight(head, 2).also { println(it?.`val`) }

}