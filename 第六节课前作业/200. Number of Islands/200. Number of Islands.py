class Solution:
    """
    BFS, 时间复杂度 O(n*m), 空间复杂度 O(n*m)
    """
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if(grid[i][j] == "1"):
                    self.bfs(grid, i, j)
                    res += 1    # 一个岛屿，因为其他都会扩散出去变成一个
        return res
    
    
    def bfs(self, grid, i, j):
        queue = deque([(i, j)])
        grid[i][j] = "0"      # mark start point as visited
        
        while queue:
            I,J = queue.popleft()
            for i, j in [I+1, J], [I, J+1], [I-1, J], [I, J-1]:   # 判断四边是否为岛屿
                if 0 <= i < len(grid) and 0 <= j < len(grid[0]) and grid[i][j] == "1":
                    grid[i][j] = "0"      # mark this point as visited
                    queue.append((i,j))   # 找他的邻居
            