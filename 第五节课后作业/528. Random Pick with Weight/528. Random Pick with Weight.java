class Solution {
    private int[] prefixSum;
    private int sum;

    /* 思路：看成是一段一段，长度就是前缀和。 用random计算出pick的长，看落在哪段区域
     * Time: constructor - O(n); pickIndex - O(logn)
     * Space: constructor - O(n); picIndex - O(1)
     */
    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        int curSum = 0;
        
        // 计算前缀和
        for(int i = 0; i < w.length; i++){
            curSum += w[i];
            this.prefixSum[i] = curSum;
        }
        this.sum = curSum;    // 总和
    }
    
    public int pickIndex() {
        double randElement = Math.random() * this.sum;     // 获取随机的target
        int left = 0, right = this.prefixSum.length;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            if(randElement == this.prefixSum[mid]){
                return mid;
            }else if(randElement > this.prefixSum[mid]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}
