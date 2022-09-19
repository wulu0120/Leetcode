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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode prev = dummyNode;
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                prev.next = list1;
                list1 = list1.next;
            }
            else{
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        
        // 有list为Null, 直接添加另一个
        if(list1 == null){
            prev.next = list2;
        }
        else{
            prev.next = list1;
        }
        
        return dummyNode.next;
    }
}