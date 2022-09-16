class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        while(left < right){
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);
            
            if(height[left] <= height[right]){
                left++;      // 左<=右, 移动左, 找更大的
            }else{
                right--;
            }
        }
        return maxArea;
    }
}