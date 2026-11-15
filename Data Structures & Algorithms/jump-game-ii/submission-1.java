class Solution {
    public int jump(int[] nums) {
       int left = 0;
       int right = 0; 
       int res = 0;

       while(right < nums.length-1) {
        int far = 0;

        for(int i = left; i <= right; i++) {
            far = Math.max(far, i + nums[i]);
        }
        left = right + 1;
        right = far;

        res++;
    
       }
       return res;
    }
}
