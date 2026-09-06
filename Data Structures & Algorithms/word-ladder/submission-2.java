class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        Map<String, List<String>> nextWords = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                if (!nextWords.containsKey(pattern)) {
                    nextWords.put(pattern, new ArrayList<>());
                }

                nextWords.get(pattern).add(word);
            }
        }
        Deque<String> words = new ArrayDeque<>();
        words.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int count = 1;
        while (!words.isEmpty()) {
            int size = words.size();
            for (int q = 0; q < size; q++) {
                String word = words.poll();
                if (word.equals(endWord)) {
                    return count;
                }

                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, '*');
                    String pattern = sb.toString();
                    List<String> nx = nextWords.get(pattern);
                    if (nx == null)
                        continue;
                    for (String next : nx) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            words.offer(next);
                        }
                    }
                }
            }
            count++;
        }

        return 0;
    }
}
