package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Dui_lie_de_zui_da_zhi_lcof_m59 {

    private Queue<Integer> queue;
    private Deque<Integer> deque;
    public Dui_lie_de_zui_da_zhi_lcof_m59() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty())
            return -1;
        else
            return deque.peek();
    }

    public void push_back(int value) {
        queue.offer(value);

        while (!deque.isEmpty() && deque.getLast()<value){
            deque.pollLast();
        }
        deque.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        else {
            int pop = queue.poll();
            if (deque.size()>0 && pop == deque.peek()){
                deque.poll();
            }
            return pop;
        }

    }
}
