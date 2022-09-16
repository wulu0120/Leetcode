class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        
        /*
         1. ptr1 == ptr2, ptr1++, ptr2++, 存值
         2. ptr1 > ptr2, ptr2++
         3. ptr1 < ptr2, ptr1++
        */
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < nums1.length && ptr2 < nums2.length){
            if(nums1[ptr1] == nums2[ptr2]){
                res.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }
            else if(nums1[ptr1] > nums2[ptr2]){
                ptr2++;
            }
            else{
                ptr1++;
            }
        }
        int[] resArr = res.stream().mapToInt(i -> i).toArray();
        return resArr;
    }
}