class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for (int i = 0; i < size; i++){                 // size 包含同一层的node
                Node curNode = queue.remove();
                
                // 判断当前node是否为该level的最后node? 1.不是，next = 下一个; 2. 是，next = null;
                curNode.next = (i + 1 < size) ? queue.peek() : null;
            
                // 检查左右节点是否为null，加入queue
                if(curNode.left != null){   
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);;
                }
            }
        }
        return root;
    }
}