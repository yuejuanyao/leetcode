package stack;

import java.util.Stack;

public class zhan_de_ya_ru_dan_chu_xu_lie_lcof_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int poppedIndex = 0;
        for (int num : pushed){
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[poppedIndex] ){
                stack.pop();
                poppedIndex ++;
            }
        }
        return stack.isEmpty();
    }
}
