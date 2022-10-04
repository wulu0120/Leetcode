/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    /* 思路: 中序搜索, 放结果到arr里。Iterate = 遍历array。*/
    private ArrayList<Integer> arr;
    private int pos;

    public BSTIterator(TreeNode root) {
        arr = new ArrayList<>();
        pos = -1;
        this.inorderHelper(root);
    }
    
    // helper func: 把tree转换成sorted array
    private void inorderHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderHelper(root.left);
        this.arr.add(root.val);
        inorderHelper(root.right);
    }
    
    public int next() {
        this.pos++;
        return this.arr.get(this.pos);
    }
    
    public boolean hasNext() {
        return this.pos + 1 < this.arr.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */