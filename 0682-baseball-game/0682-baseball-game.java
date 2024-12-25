class Solution {
    public int calPoints(String[] operations) {
         Stack<Integer> stack = new Stack<>();
        
        for (String operation : operations) {
            if (operation.equals("C")) {
                stack.pop();
            } else if (operation.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (operation.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);  // Push the top back
                stack.push(newTop);  // Push the new top
            } else {
                stack.push(Integer.parseInt(operation));
            }
        }
        
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        
        return sum;
    }
}