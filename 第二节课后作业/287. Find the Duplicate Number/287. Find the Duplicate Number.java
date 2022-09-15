class Solution {
    public int findDuplicate(int[] nums) {
        int count = 0;
        int dupNum = -1;
        int left = 0, right = nums.length-1;
        
        while(left+1 < right){
            int mid = left + (right - left)/2;
            count = countSmall(nums, mid);    // 判断多少数 <= index   ****关键点是check index, 而不是对应的值
            if(count > mid){                  // 大于说明有重复
                dupNum = mid;
                right = mid;
            }else{
                left = mid;                   // 说明mid前都没重复，更新left
            }
        }
        
        if(countSmall(nums, left) > left){    // 先测left, left重复则right肯定重复
            dupNum = left;
        }
        else if(countSmall(nums, right) > right){
            dupNum = right;
        }
        return dupNum;
    }
    
    // helper fun: 判断有多少数 <= num
    private int countSmall(int[] nums, int num){
        int count = 0;
        for(int i: nums){
            if(i <= num) count++;
        }
        return count;
    }
}