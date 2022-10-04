/**   
 * https://leetcode.com/problems/distribute-coins-in-binary-tree/
 * Time: O(N), worst要看所有的node
 * Space: O(H) ?
 */
class Solution {
    int move = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }
    
    // return {# of nodes, # of coin}, 不管哪个大, 移动的都是相减的绝对值
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        
        move += Math.abs(left[0] - left[1]) + Math.abs(right[0] - right[1]);
        return new int[]{left[0] + right[0] + 1, left[1] + right[1] + root.val};
    }
}