class Solution {
    public void solve(char[][] board) {
        /* 1.遍历所有border的O，用bfs mark到的O不用翻转, 改成 E；
        2.再遍历所有，继续bfs如果是O，可以翻转 */
        if(board == null || board.length == 0) return;
        int row = board.length, col = board[0].length;
        // 存放边界值
        List<Pair<Integer, Integer>> boarders = new LinkedList<Pair<Integer, Integer>>();
        // 1. 加入所有边界
        for(int i = 0; i < row; i++){
            boarders.add(new Pair(i, 0));
            boarders.add(new Pair(i, col-1));
        }
        for(int j = 0; j < col; j++){
            boarders.add(new Pair(0, j));
            boarders.add(new Pair(row-1, j));
        }
        // 2. bfs遍历所有边界的O，改成E
        for(Pair<Integer, Integer> pair: boarders){
            bfs(board, pair.getKey(), pair.getValue());
        }
        // 3. 遍历所有，把O改成X，把E变成O
        for(int x = 0; x < row; x++){
            for(int y = 0; y < col; y++){
                if(board[x][y] == 'O') board[x][y] = 'X';
                if(board[x][y] == 'E') board[x][y] = 'O';
            }
        }
    }
    
    /* 用模板for的时候, 要看一下是否有没有level的形式, 没有可以不用for直接while */
    private void bfs(char[][] board, int first, int second){
        LinkedList<Pair<Integer, Integer>> neighbor = new LinkedList<Pair<Integer, Integer>>();
        neighbor.offer(new Pair<>(first, second));
        while(!neighbor.isEmpty()){
            Pair<Integer, Integer> pos = neighbor.pollFirst();
            int row = pos.getKey(), col = pos.getValue();
            if(board[row][col] != 'O') continue;    // 不是O，直接下一个扩散
            board[row][col] = 'E';    // 把当前的O变成E

            // 判断四个邻居情况，如果是O, 加入neighbor继续扩散
            if(row > 0) neighbor.add(new Pair(row-1, col));
            if(col > 0) neighbor.add(new Pair(row, col-1));
            if(row < board.length - 1) neighbor.add(new Pair(row+1, col));
            if(col < board[0].length - 1) neighbor.add(new Pair(row, col+1));  
        }
    }
}