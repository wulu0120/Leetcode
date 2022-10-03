class Solution {
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