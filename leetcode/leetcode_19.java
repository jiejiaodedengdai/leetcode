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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // 快慢指针 一个先移动n次   一个不移动
        ListNode dummy = new ListNode( -1 );


        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        while( n != 0 ){
            n--;
            fast = fast.next;
        }

        while( fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;

    }
}