package List;

public class ReverseLinkedList {
    //递归
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode next=head.next;
        ListNode newHead=reverseList(next);
        next.next=head;
        head.next=null;
        return newHead;
    }

    //头插法
}
