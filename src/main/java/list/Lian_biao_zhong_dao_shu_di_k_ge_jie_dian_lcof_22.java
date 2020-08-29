package list;

public class Lian_biao_zhong_dao_shu_di_k_ge_jie_dian_lcof_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <=0)
            return null;
        ListNode res = head;
        int i = 1;
        while (i < k && head != null){
            head = head.next;
            i++;
        }
        if(head == null)
            return null;
        while (head.next != null){
            head = head.next;
            res = res.next;
        }
        return res;
    }
}
