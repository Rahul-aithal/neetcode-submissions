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

class PrefixTree {
    Trie[] alphabets;
    public PrefixTree() {
        this.alphabets = new Trie[26];
    }

    public void insert(String word) {
        Trie[] local = this.alphabets;

        for (int i = 0; i < word.length(); i++) {
            char localChar = word.charAt(i);
            int localCharIdx = localChar - 'a';

            if (local[localCharIdx] == null) {
                local[localCharIdx] = new Trie(localChar);
            }
            if (i == word.length() - 1) {
                local[localCharIdx].setEnd();
            }
            local = local[localCharIdx].children;
        }
    }

    public boolean search(String word) {
        Trie[] local = this.alphabets;

        for (int i = 0; i < word.length(); i++) {
            char localChar = word.charAt(i);
            int localCharIdx = localChar - 'a';

            if (local[localCharIdx] == null) {
                return false;
            }
            if (i == word.length() - 1) {
                if (local[localCharIdx].isEnd) {
                    return true;
                }
                return false;
            }
            local = local[localCharIdx].children;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        Trie[] local = this.alphabets;

        for (int i = 0; i < prefix.length(); i++) {
            char localChar = prefix.charAt(i);
            int localCharIdx = localChar - 'a';

            if (local[localCharIdx] == null) {
                return false;
            }
            // if (i == word.length() - 1) {
            //     if (local[localChar].isEnd) {
            //         return true;
            //     }
            //     return false;
            // }
            local = local[localCharIdx].children;
        }
        return true;
    }
}
