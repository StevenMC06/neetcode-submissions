class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        int[][] cars = new int [position.length][2];
    
        for(int i = 0; i< position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> b[0] - a[0]);

        for(int i = 0; i < position.length; i++) {
            double currTime = (target - cars[i][0]) / (cars[i][1]*1.0);
            if(stack.isEmpty()||currTime > stack.peek()) {
                stack.push(currTime);
            }
        }


        return stack.size();
    }
}
