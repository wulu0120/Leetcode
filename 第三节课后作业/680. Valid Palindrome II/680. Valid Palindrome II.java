class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                // 对左或者右做删除, 任意一个符合就行
                return (checkValid(s, l, r-1) || checkValid(s, l+1, r));
            }
            l++;
            r--;
        }
        return true;
    }
    
    // helper fun: 对删除后的子串查找, 如果有不同直接返回false
    private boolean checkValid(String s, int l, int r){
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}