class Solution {
    List<String> res = new ArrayList<>();
    String digits;
    String[] map = {
        "", "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")|| digits.equals("1")) {
            return res;
        }
        this.digits = digits;
        dfs(0, "");
        return res;
    }

    private void dfs(int index, String curr) {
        if(curr.length() == digits.length()){
            res.add(curr);
            return;
        }

        char digit = digits.charAt(index);

        String letters = map[digit - '0'];

        for (int i = 0; i < letters.length(); i++) {

            char letter = letters.charAt(i);

            dfs(index + 1, curr + letter);

            
        }
    }
}
