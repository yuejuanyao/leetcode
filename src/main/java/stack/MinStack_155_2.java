package stack;

import java.util.Stack;

public class MinStack_155_2 {

    private Stack<Integer> data;

    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public MinStack_155_2() {
        data = new Stack<Integer>();
        helper = new Stack<Integer>();
    }

    public void push(int x) {
        data.push(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.push(x);
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            int top = data.pop(); //这里注意如果是Integer要用equal方法
            if (!helper.isEmpty() && helper.peek() == top) {
                helper.pop();
            }
        }
    }

    public int top() {
        if (!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }

    public int getMin() {
        if (!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }
}
