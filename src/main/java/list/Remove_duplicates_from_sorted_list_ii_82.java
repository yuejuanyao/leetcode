package list;

public class Remove_duplicates_from_sorted_list_ii_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode pre = newHead;
        ListNode cur = head;
        ListNode next = head.next;
        while(next != null){
            if(next.val != cur.val){
                if(next != cur.next){
                    pre.next = next;
                    cur = next;
                }else{
                    pre = cur;
                    cur = next;
                    pre.next = next;
                }
            }
            next = next.next;
        }
        if(cur.next!=null && cur.val == cur.next.val)
            pre.next = next;
        return newHead.next;
    }
}
