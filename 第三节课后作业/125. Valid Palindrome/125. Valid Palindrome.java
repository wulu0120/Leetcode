class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        int l = 0, r = s1.length()-1;
        while(l <= r){
            if(s1.charAt(l) != s1.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}