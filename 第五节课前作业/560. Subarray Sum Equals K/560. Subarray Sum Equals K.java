class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // 记录(和, 出现次数)
        int count = 0, sum = 0;
        
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                count += map.get(sum-k);  // 获取sum-k的出现次数
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);  // 更新sum的出现次数  
        }
        return count;
    }
}