package stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack_1 {
    /**
     * 入栈O(n)出O(1)
     */

    private Queue<Integer> queue;
    private Queue<Integer> queueForChange;
    private Integer top;
    /** Initialize your data structure here. */
    public MyStack_1() {
        queue = new LinkedList<>();
        queueForChange = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while (!queue.isEmpty()){
            queueForChange.offer(queue.remove());
        }
        queue.offer(x);
        top = x;
        while (!queueForChange.isEmpty()){
            queue.offer(queueForChange.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int x = queue.remove();
        top = queue.peek();
        return x;
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
