package list;

public class Reverse_linked_list_206 {
    //头插入方法
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        while (head != null){
            ListNode cur = head;
            head = head.next;
            cur.next = newHead;
            newHead= cur;
        }
        return newHead;
    }

    //递归方法
    public ListNode reverseList_1(ListNode head) {
        //返回的条件
        if(head==null || head.next ==null)
            return head;
        //新的头节点
        ListNode newhead = reverseList_1(head.next);
        head.next.next = head;
        head.next = null;
        return newhead;
    }
}
