/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        
          // 创建虚拟头节点，简化头节点处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        // 当prev后面有至少两个节点时，进行交换
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;       // 第一个节点
            ListNode second = prev.next.next; // 第二个节点
            
            // 交换节点
            prev.next = second;   // prev指向第二个节点
            first.next = second.next; // 第一个节点指向第二个节点的下一个节点
            second.next = first;  // 第二个节点指向第一个节点
            
            // 移动prev到下一对节点的前一个位置
            prev = first;
        }
        
        // 返回交换后的链表头节点
        return dummy.next;

    }
}