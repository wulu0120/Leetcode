class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r){
            if(nums[l] % 2 != 0){   // 奇数, 交换
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                r--;    // 当前换到的那一位之后都ok了
            }
            else{
                l++;   // 之前的都Ok了
            }
        }
        return nums;
    }
}