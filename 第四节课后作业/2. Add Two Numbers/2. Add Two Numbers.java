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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int addOne = 0;   // 判断是否要进位
        
        while(l1 != null || l2 != null || addOne != 0){
            int v1 = (l1 == null) ? 0 : l1.val;   // 为空则标0
            int v2 = (l2 == null) ? 0 : l2.val;
            
            int sum = v1 + v2 + addOne;   
            addOne = sum / 10;    // 进位数
            cur.next = new ListNode(sum % 10); 
            cur = cur.next;
            
            if(l1 != null){
                l1 = l1.next;   // 查看l1下一位
            }
            if(l2 != null){
                l2 = l2.next;   // 查看l2下一位
            }
        }
        return dummy.next;
    }
}