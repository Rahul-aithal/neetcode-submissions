class Solution {
    HashMap<Character, List<Character>> map = new HashMap<>();
    List<String> res = new ArrayList<>();
    public void buildMap() {
        this.map.put('2', new ArrayList<>(List.of('a', 'b', 'c')));
        this.map.put('3', new ArrayList<>(List.of('d', 'e', 'f')));
        this.map.put('4', new ArrayList<>(List.of('g', 'h', 'i')));
        this.map.put('5', new ArrayList<>(List.of('j', 'k', 'l')));
        this.map.put('6', new ArrayList<>(List.of('m', 'n', 'o')));
        this.map.put('7', new ArrayList<>(List.of('p', 'q', 'r', 's')));
        this.map.put('8', new ArrayList<>(List.of('t', 'u', 'v')));
        this.map.put('9', new ArrayList<>(List.of('w', 'x', 'y', 'z')));
    }
    public List<String> letterCombinations(String digits) {
        buildMap();
        StringBuilder sb = new StringBuilder();
        if (digits.length() == 0)
            return res;
        else
            dfs(0, digits, sb);
        return res;
    }

    public void dfs(int i, String digits, StringBuilder sb) {
        if (i >= digits.length()) {
            res.add(sb.toString());
            return;
        }
        List<Character> chars = map.get(digits.charAt(i));

        for (int j = 0; j < chars.size(); j++) {
            sb.append(chars.get(j));
            dfs(i + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
