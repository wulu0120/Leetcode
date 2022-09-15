class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[mid+1]){   // 递增在mid左边
                r = mid;
            }
            else{
                l = mid + 1;  // 递增在mid右边
            }
        }
        return l;
    }
}