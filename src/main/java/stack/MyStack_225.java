package stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack_225 {
    /**
     * 入栈O(1)出O(n)
     */

    private Queue<Integer> queue;
    private Queue<Integer> queueForChange;
    private Integer top;
    /** Initialize your data structure here. */
    public MyStack_225() {
        queue = new LinkedList<>();
        queueForChange = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        top = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        Queue<Integer> tmp;
        while (queue.size()>1){
            top = queue.remove();
            queueForChange.offer(top);
        }
        tmp = queueForChange;
        queueForChange = queue;
        queue = tmp;
        return queueForChange.remove();
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */