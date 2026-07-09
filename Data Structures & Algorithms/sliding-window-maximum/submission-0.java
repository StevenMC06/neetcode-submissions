class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a,b) -> b[0]-a[0]);

        int resIndex = 0;

        for(int r = 0; r<n ; r++) {
            // Add curr value + index to heap
            maxHeap.offer(new int[]{nums[r], r});
            if(r >= k - 1) {
                int left = r - k + 1;

                while(maxHeap.peek()[1] < left) {
                    maxHeap.poll();
                }

                result[resIndex] = maxHeap.peek()[0];
                resIndex++;
            }
            
        }

        return result;
    }
}
