class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head); 
        
        ListNode cur = head;
        ListNode pred = dummy;
        
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pred.next = cur.next; // skip dups
            }else{
                pred = pred.next;   // 下一个符合, 保留
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}