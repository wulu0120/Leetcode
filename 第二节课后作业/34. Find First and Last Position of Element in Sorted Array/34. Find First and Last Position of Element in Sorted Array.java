class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 0) return res;
        
        res[0] = findBound(nums, target, false);
        res[1] = findBound(nums, target, true);
        return res;
    }
    
    // helper func: 根据direction值查找边界, 左->false, 右->true
    private int findBound(int[] nums, int target, boolean direction){
        int left = 0, right = nums.length-1;
        while(left+1 < right){
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target){
                if(!direction){
                    // case1: 最左边 or mid-1 != target
                    if(mid == left || nums[mid-1] != target){
                        return mid;
                    }else{
                        right = mid;
                    }
                }
                else{
                    // case2: 最右边 or mid+1 != target
                    if(mid == right || nums[mid+1] != target){
                        return mid;
                    }else{
                        left = mid;
                    }
                } 
            }
            // 进行边界调整
            else if (nums[mid] > target){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        // 判断 left, right是否为边界
        if(!direction){
            if(nums[left] == target){
                return left;     // 先判断左边是因为要找最小的
            }
            if(nums[right] == target){
                return right;
            }
        }else{
            if(nums[right] == target){
                return right;    // 先判断右边是因为要找最大的
            }
            if(nums[left] == target){
                return left;
            }
        }
        return -1;
    }
}