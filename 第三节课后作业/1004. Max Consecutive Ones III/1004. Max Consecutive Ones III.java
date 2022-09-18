class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right, maxLength = 0;
        for(right = 0; right < nums.length; right++){
            if(nums[right] == 0) k--;   // flip a 0
            if(k < 0){
                maxLength = Math.max(maxLength, right-left); // 取最大的长度
                k += 1 - nums[left];    // 如果被丢掉的left为0, 增加k
                left++;
            }
        }
        return Math.max(maxLength, right-left);   // k未达到但已走到末尾
    }
}