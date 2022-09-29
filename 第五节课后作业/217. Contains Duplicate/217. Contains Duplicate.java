class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int i: nums){
            // HashSet有了说明出现了第2次, 直接true
            if(numSet.contains(i)) return true;
            numSet.add(i);
        }
        return false;
    }
}
// Time Complexity: O(n); Space Complextiy: O(n)