public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        HashSet<ListNode> nodeSet = new HashSet<>();   
        
        // Type为ListNode, 因为两个ListNode虽然val值相同, 但是next跟的node不同, 所以是两个不同的对象
        ListNode cur = head;
        while(cur != null){
            if(nodeSet.contains(cur)){
                return true;
            }else{
                nodeSet.add(cur);
                cur = cur.next;
            }
        }
        return false;
    }
}