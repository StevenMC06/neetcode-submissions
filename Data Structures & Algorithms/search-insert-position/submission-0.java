class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = nums.length;
        int left = 0, right = nums.length-1;

        while(left <= right) {
            int mid = (right+left) /2;
            if(nums[mid] == target) {
                return mid;
            } 
            if(nums[mid] > target) {
                res = mid;
                right = mid -1 ;
            } else {
               left = mid + 1;
            }
        }

        return res;
    }
}