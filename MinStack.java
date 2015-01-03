/*
 Author:     King, wangjingui@outlook.com
 Date:       Nov 14, 2014
 Problem:    Min Stack 
 Difficulty: Easy
 Source:     https://oj.leetcode.com/problems/min-stack/
 Notes:
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
*/

class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();
    public void push(int x) {
      stack.push(x);
      if (minStack.isEmpty() || x <= minStack.peek()) {
         minStack.push(x);
      }
    }
    public void pop() {
      if (stack.pop().equals(minStack.peek())) minStack.pop();
    }
    public int top() {
      return stack.peek();
    }
    public int getMin() {
      return minStack.peek();
    }
}