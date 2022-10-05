class Solution {
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        maxDepth(root);
        return diameter;
    }
    
    /* helper func: 返回当前node后的最大深度 = 左右子树的最大值 + 1 */
    private int maxDepth(TreeNode node) {
        if (node == null) return 0;
        int leftCount = maxDepth(node.left);
        int rightCount = maxDepth(node.right);
        // 检查当前节点的diameter是否更大并更新
        diameter = Math.max(diameter, leftCount + rightCount);
        return (leftCount < rightCount) ? rightCount + 1 : leftCount + 1;
    }
}