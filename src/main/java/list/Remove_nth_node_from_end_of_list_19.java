package list;

import javafx.application.Application;
import javafx.stage.Stage;

public class Remove_nth_node_from_end_of_list_19 {
    //递归法
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0)
            return head;
        if (delete(head,n) == n)
            head = head.next;
        return head;
    }
    int delete(ListNode cur , int n){
        ListNode next = cur.next;
        if (next == null)
            return 1;
        int nextPosition = delete(next, n) ;
        if (nextPosition == n){
            cur.next = cur.next.next;
        }
        return nextPosition + 1;
    }

    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i = 0;
        ListNode last = dummy;
        ListNode pre = dummy;
        while (i<n){
            last = last.next;
            i++;
        }
        while (last.next != null){
            last = last.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
