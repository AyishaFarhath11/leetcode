class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        // Iterate through each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {  // Found land
                    islandCount++;
                    // Perform DFS to mark all connected lands
                    dfs(grid, i, j, rows, cols);
                }
            }
        }

        return islandCount;
    }
    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        // Check if the current position is out of bounds or is water ('0')
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }

        // Mark the current land cell as visited by changing it to water
        grid[i][j] = '0';

        // Visit all the adjacent cells (up, down, left, right)
        dfs(grid, i - 1, j, rows, cols);  // Up
        dfs(grid, i + 1, j, rows, cols);  // Down
        dfs(grid, i, j - 1, rows, cols);  // Left
        dfs(grid, i, j + 1, rows, cols);  // Right
    }

}