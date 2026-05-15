class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile: piles) {
            right = Math.max(right, pile); 
        }

        int res = right;
        while(left <= right) {
            int k =  (left + right) /2;
            int hours = 0;

            for(int i = 0; i< piles.length;i++) {
                hours += Math.ceil((double) piles[i]/k);
            }

            if(hours <= h) {
                res = k;
                right = k-1;    
            } else {
                left = k+1;
            }

        }
        return res;
    }
}
