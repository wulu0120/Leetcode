class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        
        int left = 2, right = x/2;
        long nums;
        
        while(left + 1 < right){
            int middle = left + (right - left) / 2;
            nums = (long) middle * middle;    // 比较当前数值平方后与x的大小关系
            
            if(nums == x){
                return middle;
            }
            else if (nums > x){
                right = middle;
            }
            else{
                left = middle;
            }
        }
        // ***先比较右边, 因为x比右边大, 肯定比左边要大***
        if((long) right * right <= x){
            return right;
        }
        return left;
    }
}