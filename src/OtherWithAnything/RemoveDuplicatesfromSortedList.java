package OtherWithAnything;

public class RemoveDuplicatesfromSortedList {
    public static void main(String[] args){

    }
    public ListNode remove(ListNode head){
         ListNode newhead=head;
         ListNode temp=head;
         while (head!=null){
             int num=head.val;
             temp=head;
             while (num==temp.val){
                 temp=temp.next;
             }
             head.next=temp;
             head=temp;
         }
         return newhead;
    }

    public ListNode remove_method2(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        head.next=remove_method2(head.next);//递归停止时head指向倒数第二个元素，head.next指向最后一个元素
        return head.val==head.next.val?head.next:head;//对上一层head.next想要的结果返回
    }
    //递归思路：要对某子链表进行消重，转为链表第一个元素与链表剩下的元素的消重结果在消重。每次规模减小1
    //递归停止条件：当head==null||head.next==null时停止，此时的head指向倒数第二个元素，
}
