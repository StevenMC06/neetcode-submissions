class Solution {
    public int maxArea(int[] heights) {
        int res = 0;
        
        int l = 0;
        int r= heights.length -1 ;
        
        while(l < r) {
            int height = Math.min(heights[l], heights[r]);
            int width = r-l;
            int curr = height * width;

            if(curr > res) {
                res = curr;
            } else {
                if(heights[l]<heights[r]) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
