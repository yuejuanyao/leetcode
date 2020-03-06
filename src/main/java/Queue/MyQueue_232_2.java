package Queue;

import java.util.Stack;

public class MyQueue_232_2 {

    Stack<Integer> stack;
    Stack<Integer> stack_tmp;
    Integer front;
    /** Initialize your data structure here. */
    public MyQueue_232_2() {
        stack = new Stack<>();
        stack_tmp = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack.isEmpty()){
            front = x;
        }
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack_tmp.isEmpty()){
            while (!stack.isEmpty()){
                stack_tmp.push(stack.pop());
            }
        }
        return stack_tmp.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(stack_tmp.isEmpty())
            return front;
        return stack_tmp.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty() && stack_tmp.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
