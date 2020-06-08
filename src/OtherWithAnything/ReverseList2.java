package OtherWithAnything;

public class ReverseList2 {
    public static void main(String[] args){}

    public ListNode getRes1(ListNode head){
        ListNode tempHead=null;
        while (head!=null){
            tempHead=head.next.next;
            head.next.next=head;
            head=tempHead;
        }
        return head;
    }

    public ListNode getRes2(ListNode head){
        if (head.next==null||head==null){
            return head;
        }
        ListNode newHead=getRes1(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }


}
