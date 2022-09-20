class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while(cur != null){    // 此时还有值需要换方向
            ListNode temp = cur.next;
            cur.next = prev;   // 改变方向
            prev = cur;
            cur = temp;     
        }
        return prev;
    }  
}