class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    int target;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        dfs(0, 0, new ArrayList<>());

        return res;
    }

    private void dfs(int startIndex, int currentSum, List<Integer> path) {
        // base case 1
        if(currentSum == target) {
            res.add(new ArrayList<>(path));
            return ;
        }
        // base case 2

        if(currentSum > target) {
            return;
        }

        for(int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i, currentSum + nums[i], path);

            path.remove(path.size()-1);
        }

        // try from start index to end


    }
}
