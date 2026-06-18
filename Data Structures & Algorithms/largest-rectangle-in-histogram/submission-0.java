class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;

        for(int i = 0; i < heights.length; i++) {
            int start = i;
            int height = heights[i];

            while(!stack.isEmpty() && height < stack.peek()[1]) {
                int[] pair = stack.pop();

                //calc area using pair 1 as height

                int width = i - pair[0];
                maxArea = Math.max(maxArea, (width*pair[1]));
                start = pair[0];
            }

            // push new int 
            stack.push(new int[]{start,height});


        }
        while(!stack.isEmpty()) {
            int[] pair = stack.pop();
            int width = heights.length - pair[0];
            maxArea = Math.max(maxArea, (width * pair[1]));
        }

        return maxArea; 
    }
}
