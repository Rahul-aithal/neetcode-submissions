class Trie {
    char c;
    boolean isEnd;
    Trie[] children;
    public Trie() {
        this.children = new Trie[26];
    }
    public Trie(char c) {
        this.c = c;
        this.children = new Trie[26];
    }
    public Trie(char c, boolean isEnd) {
        this.isEnd = isEnd;
        this.c = c;
        this.children = new Trie[26];
    }

    public void insertChild(Trie child) {
        if (this.children[child.c - 'a'] == null)
            this.children[child.c - 'a'] = child;
    }
    public void setEnd() {
        this.isEnd = true;
    }
}

class WordDictionary {
    Trie alphabets;

    public WordDictionary() {
        this.alphabets = new Trie();
    }

    public void addWord(String word) {
        Trie local = this.alphabets;

        for (int i = 0; i < word.length(); i++) {
            char localChar = word.charAt(i);
            int localCharIdx = localChar - 'a';

            if (local.children[localCharIdx] == null) {
                local.children[localCharIdx] = new Trie(localChar);
            }
            if (i == word.length() - 1) {
                local.children[localCharIdx].setEnd();
            }
            local = local.children[localCharIdx];
        }
    }

    public boolean search(String word) {
        Trie local = this.alphabets;
        return dfs(local, 0, word);
    }
    private boolean dfs(Trie local, int j, String word) {
        for (int i = j; i < word.length(); i++) {
            char localChar = word.charAt(i);
            if (localChar == '.') {
                for (Trie child : local.children) {
                    if (child != null && dfs(child, i + 1, word))
                        return true;
                }
                return false;
            } else {
                int localCharIdx = localChar - 'a';

                if (local.children[localCharIdx] == null) {
                    return false;
                }
               
                local = local.children[localCharIdx];
            }
        }
        return local.isEnd;
    }
}
