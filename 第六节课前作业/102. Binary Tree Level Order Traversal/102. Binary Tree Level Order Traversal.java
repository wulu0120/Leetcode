class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> lst = new ArrayList<>();  // 存要加进去的左右节点
            
            for (int i = 0; i < size; i++){       // size 包含同一层的node
                TreeNode curNode = queue.poll();  // 获取当前处理的node, 加到lst
                lst.add(curNode.val);
            
                // 检查左右节点是否为null，加入queue
                if(curNode.left != null){   
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);;
                }
            }
            res.add(lst);     // 把当前level加入到res
        }
        return res;
    }
}