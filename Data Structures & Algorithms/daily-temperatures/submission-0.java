class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int currTemp= temperatures[i];
            while(!stack.isEmpty() && currTemp > temperatures[stack.peek()]) {
                int oldIndex = stack.pop();

                res[oldIndex] = i - oldIndex;
            }
            stack.push(i);
        }

        return res;
    }
}
