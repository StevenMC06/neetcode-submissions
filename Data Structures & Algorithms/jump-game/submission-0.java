class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;

        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];

            if(i > far) {
                return false;
            }
            far = Math.max(far, i + x);
        }

        return true;
    }
}
