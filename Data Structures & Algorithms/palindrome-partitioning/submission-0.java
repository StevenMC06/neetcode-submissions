class Solution {
    List<List<String>> res = new ArrayList<>();
    String s;


    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int index, List<String> path){
        if(index == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int end = index; end < s.length(); end++) {
            if(isPalindrome(index,end)) {
                path.add(s.substring(index, end+1));

                dfs(end+1, path);

                path.remove(path.size()-1);
            }
        }
    }   
    private boolean isPalindrome(int left, int right) {
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        left++;
        right--;
    }

    return true;
}
}
