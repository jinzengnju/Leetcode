package OtherWithAnything;

class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){this.val=x;}
}
public class ReverseList {
    public static void main(String[] args){}
    public ListNode getRes(ListNode head){
        if (head==null||head.next==null)
            return head;
        //1-2-3-4-5-null，要反转这个链表，先反转2-3-4-5-null，head.next指向的2，2的next为head.next.next，修改为指向1
        ListNode newHead=getRes(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
