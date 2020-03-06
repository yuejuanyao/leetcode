package stack;

import java.util.Stack;

public class MinStack_155 {

    private Stack<Integer> data;

    private Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack_155() {
        data = new Stack<Integer>();
        helper = new Stack<Integer>();
    }

    public void push(int x) {
        data.push(x);
        if(helper.isEmpty() || helper.peek() >= x){
            helper.push(x);
        }else {
            helper.push(helper.peek());
        }
    }

    public void pop() {
        if(!data.isEmpty()){
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        if(!data.isEmpty()) {
            return data.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }

    public int getMin() {
        if(!helper.isEmpty()) {
            return helper.peek();
        }
        throw new RuntimeException("栈中元素为空");
    }
}
