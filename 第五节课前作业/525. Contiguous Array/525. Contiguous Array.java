class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);   // 放 sum, index
        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0) ? -1 : 1;
            if(map.containsKey(sum - 0)){
                // 相当于get subarray which sum = k = 0
                maxLen = Math.max(maxLen, i - map.get(sum - 0));
            }else{
                map.put(sum, i);
            }   
        }
        return maxLen;
    }
}