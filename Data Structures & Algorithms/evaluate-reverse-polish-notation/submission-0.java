class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < tokens.length; i++) {
            String curr = tokens[i];

            // addition
            if(curr.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 + val2);

            // subtraction
            }else if(curr.equals("-")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2 - val1);            
            // multiplication
            }else if(curr.equals("*")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val1 * val2);

            } else if (curr.equals("/")) {
                int val1 = stack.pop();
                int val2 = stack.pop();
                stack.push(val2/ val1);
            } else {
                stack.push(Integer.parseInt(curr));
            }
            // division
            
        }

        return stack.pop();
    }
}
