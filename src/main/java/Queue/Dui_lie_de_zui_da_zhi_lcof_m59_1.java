package Queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Dui_lie_de_zui_da_zhi_lcof_m59_1 {
    private int[] queue;
    private int maxValue;
    private int front;
    private int tail;

    public Dui_lie_de_zui_da_zhi_lcof_m59_1() {
        this.queue = new int[15000];
        this.maxValue = -1;
        this.front = this.tail = 0;
    }

    public int max_value() {
        return maxValue;
    }

    public void push_back(int value) {
        queue[tail++] = value;
        if (value > maxValue) {
            maxValue = value;
        }
    }

    public int pop_front() {
        if (tail - front == 0)
            return -1;
        else {
            int pop = queue[front++];
            if (pop == maxValue) {
                maxValue = -1;
                for (int index = front; index < tail; index++){
                    if (queue[index] > maxValue)
                        maxValue = queue[index];
                }
            }
            return pop;
        }

    }
}
