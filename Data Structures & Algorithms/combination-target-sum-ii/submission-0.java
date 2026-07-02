class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;

        Arrays.sort(this.candidates);

        dfs(0,0, new ArrayList<>());

        return res;
    }

    private void dfs(int startIndex, int currSum, List<Integer> path) {
        if(currSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(currSum > target) {
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i-1]){
                continue;
            }
            path.add(candidates[i]);
            dfs(i+1, currSum + candidates[i], path);

            path.remove(path.size()-1);
        }
    }
}
