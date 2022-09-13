class Solution{
    public int[] intersection(int[] nums1, int[] nums2) {
        // 1: 通过hashset对nums1去重
        HashSet<Integer> set1 = new HashSet<>();
        for(int i: nums1){
            set1.add(i);
        }
        
        // 2: loop nums2的值, 出现重复的加到新hashset里
        HashSet<Integer> sameElement = new HashSet<>();
        for(int j: nums2){
            if(set1.contains(j)) sameElement.add(j);
        }
        
        // 3. 返回结果
        int[] res = new int[sameElement.size()];
        int index = 0;
        for(int ele: sameElement){
            res[index++] = ele;
        }
        return res;
    }
}