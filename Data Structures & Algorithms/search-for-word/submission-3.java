class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        int size = board.length*board[0].length;;
        if(size<wordChar.length) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean found = search(board, wordChar, i, j, 0,'s');
                if (found)
                    return true;
            }
        }
        return false;
    }
    public boolean search(char[][] board, char[] word, int i, int j, int completed, char dir) {
        if (i < 0 || j < 0)
            return false;
        if (i >= board.length || j >= board[i].length)
            return false;
        // System.out.println(word[completed]);
        // System.out.println(board[i][j]);
        if (word[completed] - 'A' == board[i][j] - 'A') {
            completed++;

            if (completed == word.length)
                return true;
            if (dir != 'l') {
                boolean right = search(board, word, i + 1, j, completed, 'r');
                if (right)
                    return right;
            }
            if (dir != 'r') {
                boolean left = search(board, word, i - 1, j, completed, 'l');
                if (left)
                    return left;
            }
            if (dir != 'u') {
                boolean down = search(board, word, i, j + 1, completed, 'd');
                if (down)
                    return down;
            }
            if (dir != 'd') {
                boolean up = search(board, word, i, j - 1, completed, 'u');

                if (up)
                    return up;
            }
        }
        return false;
    }
}
