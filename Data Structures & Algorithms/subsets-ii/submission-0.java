class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int nums[];
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);

        dfs(0, new ArrayList<>());
        return res;
    }

    private void dfs(int startIndex, List<Integer> subset ) {
        res.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i-1]) {
                continue;
            }
            subset.add(nums[i]);
            dfs(i+1, subset);
            subset.remove(subset.size()-1);
        }
      

        

    }
}
