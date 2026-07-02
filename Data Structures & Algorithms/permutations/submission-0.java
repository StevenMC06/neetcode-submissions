class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        boolean[] used = new boolean[nums.length];
        dfs(new ArrayList<>(), used);
        return res;
    }

    private void dfs(List<Integer> path, boolean[] used) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }

            path.add(nums[i]);
            used[i] = true;

            dfs(path,used);

            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}
