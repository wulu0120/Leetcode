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
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode, fast = dummyNode;
        
        
        // 让fast比slow多n
        while(n >= 0){
            fast = fast.next;
            n--;
        }
        
        // 当fast到末尾时, slow的下一个是要删的node
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;    // 删除该node
        return dummyNode.next;
    }
}