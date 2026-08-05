class Trie {
    public char c;
    public Map<Character, List<Trie>> children;
    public boolean visited;

    public Trie() {
        this.children = new HashMap<>();
    }
    public Trie(char c) {
        this.c = c;
        this.children = new HashMap<>();
    }
    public void addChild(Trie child) {
        if (!this.has(child.c)) {
            this.children.put(child.c, new ArrayList<>());
        }
        this.children.get(child.c).add(child);
    }
    public boolean has(char c) {
        return this.children.containsKey(c);
    }
}

class Solution {
    Trie root = new Trie();
    Trie[][] tBoard;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        int coll = board[0].length;
        int rowl = board.length;
        this.tBoard = new Trie[rowl][coll];
        for (int i = 0; i < rowl; i++) {
            for (int j = 0; j < coll; j++) {
                Trie t = getTrie(i, j, board[i][j]);
                if (i - 1 >= 0) {
                    Trie child = getTrie(i - 1, j, board[i - 1][j]);
                    t.addChild(child);
                }
                if (j - 1 >= 0) {
                    Trie child = getTrie(i, j - 1, board[i][j - 1]);
                    t.addChild(child);
                }
                if (i + 1 < rowl) {
                    Trie child = getTrie(i + 1, j, board[i + 1][j]);
                    t.addChild(child);
                }
                if (j + 1 < coll) {
                    Trie child = getTrie(i, j + 1, board[i][j + 1]);
                    t.addChild(child);
                }
            }
        }
        for (String word : words) {
            if (searchWord(word, 0, root)) {
                result.add(word);
            }
        }
        return result;
    }
    public boolean searchWord(String word, int i, Trie root) {
        if (root.visited)
            return false;
        if (i >= word.length()) {
            return true;
        }

        if (!root.has(word.charAt(i))) {
            // System.out.println(word.charAt(i));
            // System.out.println(root.has(word.charAt(i)));
            return false;
        }
        List<Trie> children = root.children.get(word.charAt(i));
        root.visited = true;
        for (Trie child : children) {
            if (searchWord(word, i + 1, child)) {
                // System.out.println(i);

                // System.out.println("Search Pased " + child.c);
                // System.out.println("Visted" + child.visited);
                // System.out.println(child);
                root.visited = false;
                return true;
            }
            // System.out.println("Search Faild " + child.c);
        }

        root.visited = false;
        return false;
    }

    public Trie getTrie(int i, int j, char c) {
        if (this.tBoard[i][j] == null) {
            Trie t = new Trie(c);
            this.tBoard[i][j] = t;
            this.root.addChild(t);
        }
        return this.tBoard[i][j];
    }
}
