package list;

public class Middle_of_the_linked_list_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int lengthOfList = 0;
        ListNode cur = head;
        while (cur != null){
            lengthOfList ++;
            cur = cur.next;
        }
        int mid  = lengthOfList /2;
        int index = 0;
        cur = head;
        while (index < mid){
            cur = cur.next;
            index++;
        }
        return  cur;
    }

    // 快慢指针
    public ListNode middleNode_1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            low = low.next;
            fast = fast.next.next;
        }

        return low;
    }
}
