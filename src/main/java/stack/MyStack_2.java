package stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack_2 {
    /**
     * 入栈O(1)出O(n)
     * ["MyStack","push","pop","empty"] 注意top要是Integer
     * [[],[1],[],[]]
     *
     * ["MyStack","push","push","pop","top"] 注意pop之后top要变
     * [[],[1],[2],[],[]]
     */

    private Queue<Integer> queue;
    private Integer top;
    /** Initialize your data structure here. */
    public MyStack_2() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        top = x;
        int size = queue.size();
        while (size>1){
            queue.offer(queue.remove());
            size--;
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

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
