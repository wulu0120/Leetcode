class Solution {
    /* 中序遍历下，输出的二叉搜索树节点的数值是有序序列。验证二叉搜索树 = 判断一个序列是不是递增。*/
    public boolean isValidBST(TreeNode root) {
        List<Integer> treeList = inorderTraversal(root);
        for (int i = 1; i < treeList.size(); i++) {
            if (treeList.get(i-1) >= treeList.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    // 中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;    
    }
    
    // helper func: inorder -> 左中右
    private void helper(TreeNode root, List<Integer> res){
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res); 
        }    
    }
}