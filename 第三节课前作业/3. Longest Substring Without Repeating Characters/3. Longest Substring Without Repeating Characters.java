class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;    // 存长度
        
        while(right < s.length()){
            char r = s.charAt(right);
            // getOrDefault: 获取值, 没有为0
            countMap.put(r, countMap.getOrDefault(r, 0) + 1);
            
            while(countMap.get(r) > 1){
                char l = s.charAt(left);
                countMap.put(l, countMap.get(l) - 1);
                left++;      // 相当于把窗口往右移动了一格, 去掉重复的
            }
            
            res = Math.max(right-left+1, res); 
            right++;   // 扩大窗口, 判断下一个是否符合
        }
        return res;
    }
}