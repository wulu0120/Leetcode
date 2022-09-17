class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length-1;
        
        while(left < right){
            // 相当于所有左边都比mid大, 右边都比mid小, 比较mid位置和k的关系
            int mid = partition(nums, left, right);
            if(mid == k - 1){
                return nums[mid];
            }
            else if(mid < k - 1){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return nums[k - 1];
    }
    
    private int partition(int[] nums, int lo, int hi){
        // 选择一个pivot, <它的放右边, >它的放左边, return它index
        int l = lo+1, r = hi;
        int pivot = nums[lo];
        /*
          1. nums[l] <= pivot  -> left++
          2. nums[r] >= pivot -> right--
          3. nums[l] > pivot && nums[r] < pivot  -> swap(left, right)  left++ right--
        */
        while(l <= r){
            if(nums[r] <= pivot){
                r--;
            }
            else if(nums[l] >= pivot){
                l++;
            }
            else{
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        swap(nums, lo, r);  // 把pivot换到正确的位置
        return r;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}