class Solution {
    public int totalNQueens(int n) {
        return dfs(n,0,0,0);
    }
    private int dfs(int n, int cols, int d1, int d2){
        if (cols == (1 << n) - 1)return 1;
        int count = 0;
        int free = ~(cols | d1 | d2) & ((1<<n) -1);
        while (free != 0){
            int bit = free & -free;
            free -= bit;
            count += dfs(n, cols | bit, (d1 | bit) << 1, (d2 | bit) >> 1);
        }
        return count;
    }
}