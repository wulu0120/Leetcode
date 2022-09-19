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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        if(head == null) return head;
        while(curNode.next != null){
            if(curNode.next.val == curNode.val){ // 后一个val == cur val
                if(curNode.next.next != null){   // 下下一个有
                    curNode.next = curNode.next.next;
                }else{
                    curNode.next = null;   // end of the node
                }
            }
            else{
                curNode = curNode.next;
            }
        }
        return head;
    }
}