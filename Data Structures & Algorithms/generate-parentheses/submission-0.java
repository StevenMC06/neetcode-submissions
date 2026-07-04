class Solution {
    List<String> res = new ArrayList<>();
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;

        dfs(0,0, new StringBuilder());

        return res;
    }

    private void dfs(int open, int closed, StringBuilder path) {
        if(path.length() == 2 * n) {
            res.add(path.toString());
            return;
        }

        if(open < n) {
            path.append("(");
            dfs(open + 1, closed, path);
            path.deleteCharAt(path.length()-1);
        }

        if(closed < open) {
            path.append(")");
            dfs(open, closed +1, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
