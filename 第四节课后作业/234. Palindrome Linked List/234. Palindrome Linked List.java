class Solution {
    public boolean isPalindrome(ListNode head) {
        // 放到arraylist里, 再用双指针
        ArrayList<Integer> lst = new ArrayList<>();
        ListNode cur = head;
        while(cur != null){
            lst.add(cur.val);
            cur = cur.next;
        }
        
        int slow = 0, fast = lst.size() - 1;
        while(slow <= fast){
            if(lst.get(slow) != lst.get(fast)){
                return false;
            }
            slow++;
            fast--;
        }
        return true;
    }
}