class NumArray {
    private int[] sum;     // 储存prefix sum
    private int[] nums;    // 原nums array

    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum[i] = nums[i] + sum[i-1];    // 当前和 = 之前和 + 当前数值
        }
    }
    
    public int sumRange(int left, int right) {
        // (left, right) = (0, right) - (0, left) + nums[left]
        return sum[right] - sum[left] + nums[left];
    }
}