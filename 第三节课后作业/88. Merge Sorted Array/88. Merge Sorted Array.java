class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {        
        int j = m-1, k = n-1;
        for(int i = m+n-1; i >= 0; i--){
            if(k < 0) break;     // nums2 到头了, 跳出循环
            if(j >= 0 && nums1[j] >= nums2[k]){
                // nums1的最大 > nums2的最大, 把nums1的值放到最后
                nums1[i] = nums1[j--];
            }else{
                nums1[i] = nums2[k--];
            }
        }       
    }
}