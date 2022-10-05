class Solution {
    /* Time: O(N), Space: O(1) */
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }
    
    /* helper fun: 判断此root是否有1 */
    private boolean containsOne(TreeNode node) {
        if (node == null) return false;
        
        // 检查左右子树的情况
        boolean leftContains = containsOne(node.left);
        boolean rightContains = containsOne(node.right);
        
        // 如果false说明不含1, prune该子树
        if(!leftContains) node.left = null;
        if(!rightContains) node.right = null;
        
        // true的情况: 当前node为1; left有1; right有1
        return node.val == 1 || leftContains || rightContains;
    }
}