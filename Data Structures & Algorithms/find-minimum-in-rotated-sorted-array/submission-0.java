class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        int res = nums[right];

        while(left < right){
            int mid = (left + right) / 2;

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                res = Math.min(res, nums[mid]);
                right = mid;
            }
        }

        return res;
    }
}
