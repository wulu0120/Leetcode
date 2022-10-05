class Solution {
    /* Time: O(N), Space: O(1). 与543题很像, 就是此题要考虑负数的情况 
     * https://leetcode.com/problems/binary-tree-maximum-path-sum/
    */
    int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        pathSumHelper(root);
        return result;
    }
    
    /* helper func: 返回当前node的最大path sum = 左右子树的最大值 + node。val */
    private int pathSumHelper(TreeNode root) {
        if (root == null) return 0;
        int leftSum = Math.max(0, pathSumHelper(root.left));   // 0表示不考虑该子树, 可能是负数
        int rightSum = Math.max(0, pathSumHelper(root.right));
        
        // 比较并更新当前的result
        result = Math.max(result, leftSum + rightSum + root.val);
        return Math.max(leftSum, rightSum) + root.val;
    }
}