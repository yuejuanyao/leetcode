package list;

import java.io.IOException;

public class Add_two_numbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int x = 0;
        int y = 0;
        int carry = 0;
        int sum = 0;
        while (l1!=null || l2 != null){
            if (l1 != null){
                x = l1.val;
                l1 = l1.next;
            }else {
                x = 0;
            }
            if (l2 != null){
                y = l2.val;
                l2 = l2.next;
            }else {
                y = 0;
            }
            sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if (carry!=0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        if(carry > 5)
            throw new RuntimeException();
        return head.next;
    }
}
