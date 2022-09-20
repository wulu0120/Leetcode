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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode oldTail = head;
        int n;
        for(n = 1; oldTail.next != null; n++){
            oldTail = oldTail.next;    // 找到最末尾的数, 与head连起来
        }
        oldTail.next = head;
        
        ListNode newTail = head;
        // 新tail是 n - k % n - 1, 新head是它的next
        for(int i = 0; i < n - k%n - 1; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}