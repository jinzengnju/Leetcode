package List;
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
//递归解法
public class DeleteDuplicate {
    public static void main(String[] args){

    }
    public ListNode deleteDuplicate(ListNode phead){
        //递归停止条件：phead==null或者phead.next==null
        //划分子问题：为了处理122334，在第一层递归时候，在1的基础上处理链表334
        if(phead==null||phead.next==null){
            return null;
        }
        ListNode next=phead.next;
        if (next.val==phead.val){
            while(next!=null&&next.val==phead.val)
                next=next.next;
            return deleteDuplicate(next);//这里的next已经指向3了，不是2
        }else {
            phead.next=deleteDuplicate(next);
            return phead;
        }

    }


}
