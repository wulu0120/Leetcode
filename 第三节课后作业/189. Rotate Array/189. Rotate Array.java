class Solution {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            // 计算应该放置的位置 = (i+k) % length
            arr[(i+k) % nums.length] = nums[i];   
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = arr[i];    // 把结果拷贝到原nums
        }
    }
}