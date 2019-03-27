package OtherWithAnything;

public class ReverseLinkedList {
    public static void main(String[] args){}
    public ListNode reverseList(ListNode head){
        if (head==null||head.next==null)
            return head;
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
    //需要引入额外的头指针记录新链表的头节点
    public ListNode reverseList_method2(ListNode head){
        ListNode newHead=new ListNode(-1);
        while(head!=null){
            ListNode next=head.next;
            head.next=newHead.next;
            newHead.next=head;
            head=next;
        }
        return newHead.next;
    }
}
