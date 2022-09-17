class Solution {
    public void sortColors(int[] nums) {
        /*  left: 左边都是0, right: 右边都是2
          left = 0, right = nums.length-1, cur = 0
          while cur <= right:
          case1: nums[cur] == 0   -> swap left and cur, left++, cur++
          case2: nums[cur] == 2   -> swap right and cur, right--
          case3: nums[cur] == 1   -> cur++
        */
        int left = 0, right = nums.length-1, cur = 0;
        while(cur <= right){
            if(nums[cur] == 0){
                swap(nums, left, cur);
                left++;
                cur++;
            }
            else if(nums[cur] == 2){
                swap(nums, right, cur);
                right--;
            }
            else{
                cur++;
            }
        }  
    }
    
    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}