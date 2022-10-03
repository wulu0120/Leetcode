class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;  // one of the tree is null
        if (p.val != q.val) return false;
        
        // 检查左右子树是否一致
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}