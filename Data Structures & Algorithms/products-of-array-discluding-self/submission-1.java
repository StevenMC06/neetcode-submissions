class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        int currLeft = 1;
        for(int i = 0; i < nums.length; i++) {
            left[i] = currLeft;
            currLeft *= nums[i];
        }

        int currRight = 1;
        for(int i = nums.length - 1; i >=0; i--) {
            right[i] = currRight;
            currRight *= nums[i];
        }

        for(int i = 0 ; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }

        return nums;
    }
}  
