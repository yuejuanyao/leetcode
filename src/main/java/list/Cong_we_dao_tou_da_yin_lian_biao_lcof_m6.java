package list;

import java.util.Stack;

public class Cong_we_dao_tou_da_yin_lian_biao_lcof_m6 {
    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[0];
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while (head!=null){
            count++;
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[count];
        int i = 0;
        while (!stack.isEmpty() && i<count){
            res[i++] = stack.pop();
        }
        return res;
    }
    public int[] reversePrint_1(ListNode head) {
        if (head == null)
            return new int[0];
        int count = 0;
        ListNode curr = head;
        while (curr!=null){
            count++;
            curr = curr.next;
        }
        int[] res = new int[count];
        while (head != null){
            res[--count] = head.val;
            head = head.next;
        }
        return res;
    }
}
