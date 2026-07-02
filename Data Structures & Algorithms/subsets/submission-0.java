class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    private void dfs (int index, List<Integer> subset) {
        if(index == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(index +1, subset);

        subset.remove(subset.size()-1);

        dfs(index+1, subset);
    }
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0, new ArrayList<>());
        return res;

    }
}
