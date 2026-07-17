class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // current set contains 0, 1, 2, 3

        int max = 0;
        for(int curr: set) {
            if(!set.contains(curr-1)) {
                int currLength = 1;

                while(set.contains(curr+1)) {
                    currLength++;
                    curr++;
                }
                max = Math.max(max, currLength);
            }
        }

        return max;
        

    }
}
