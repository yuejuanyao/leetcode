package list;

public class Remove_linked_list_elements_203 {
    //我的🐖一样 的操作
    public ListNode removeElements(ListNode head, int val) {
     ListNode cur = head;
     ListNode per = head;
     while( head != null && head.val == val){
         head = head.next;
     }
     if(head == null)
         return null;
     while (cur != null){
         if(cur.val == val){
             per.next = cur.next;
         }else {
             per = cur;
         }
         cur = cur.next;
     }
     return head;
    }

    //添加一个头节点
    public ListNode removeElements_1(ListNode head, int val) {
        ListNode postNode = new ListNode(0);
        postNode.next = head;
        ListNode cur = head;
        ListNode per = postNode;
        if(head == null)
            return null;
        while (cur != null){
            if(cur.val == val){
                per.next = cur.next;
            }else {
                per = cur;
            }
            cur = cur.next;
        }
        return postNode.next;
    }
}
