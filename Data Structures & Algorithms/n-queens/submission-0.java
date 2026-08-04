class Solution {
    List<List<String>> res = new ArrayList<>();
    HashSet col = new HashSet();
    HashSet pdig = new HashSet(); // r+c
    HashSet ndig = new HashSet(); // r-c

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        backtrack(0, n, board);

        return res;
    }

    public void backtrack(int r, int n, char[][] board) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || pdig.contains(r + c) || ndig.contains(r - c)) {
                continue;
            }
            col.add(c);
            pdig.add(r + c);
            ndig.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, board);

            col.remove(c);
            pdig.remove(r + c);
            ndig.remove(r - c);
            board[r][c] = '.';
        }
    }
}
