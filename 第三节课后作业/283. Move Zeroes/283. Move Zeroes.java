class Solution {
    public void moveZeroes(int[] nums) {
        /* case1: slow == 0
              1.1: fast == 0   -> fast++
              1.2: fast != 0   -> swap, slow++, fast++
           case2: slow != 0  -> slow++, fast++ */
        int slow = 0;
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[slow] == 0){
                if(nums[fast] != 0){
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                    slow++;
                }
            }else{
                slow++;
            }
        }
    }
}