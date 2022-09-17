class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) return result;    // 说明后面都不符合
            if(i > 0 && nums[i] == nums[i-1]) continue;     // 对i去重
            
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi){
                /* 1. sum > 0   -> hi--;
                   2. sum < 0   -> lo++;
                   3. sum == 0  -> 添加到result, 对lo和hi做去重 */
                if(nums[i] + nums[lo] + nums[hi] > 0){
                    hi--;
                }
                else  if(nums[i] + nums[lo] + nums[hi] < 0){
                    lo++;
                }
                else{
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    
                    while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }
            }
        }
        return result;
    }
}