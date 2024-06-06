package lp

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        val row = grid.size
        if (row == 0) {
            return 0
        }
        val col = grid[0].size
        if (col == 0) {
            return 0;
        }
        val visited: Array<BooleanArray> = Array(row) { BooleanArray(col) { false } }
        var count = 0
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (visited[i][j]) {
                    continue
                }
                if (grid[i][j] == '0') {
                    continue
                }
                visit(grid, i, j, visited)
                count++
            }
        }
        return count
    }

    private fun visit(grid: Array<CharArray>, i: Int, j: Int, visited: Array<BooleanArray>) {
        if (i < 0 || i >= grid.size) {
            return
        }
        if (j < 0 || j >= grid[i].size) {
            return
        }
        if (visited[i][j]) {
            return
        }
        if (grid[i][j] == '0') {
            return
        }
        visited[i][j] = true
        visit(grid, i -1, j, visited)
        visit(grid, i, j - 1, visited)
        visit(grid, i + 1, j, visited)
        visit(grid, i, j + 1, visited)
    }
}