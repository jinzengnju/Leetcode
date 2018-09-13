package List;

import java.util.*;

//从尾到头打印链表
class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){
        val=x;
        next=null;
    }
}
public class PrintList {
    public static void main(String args){

    }
    public List<Integer> method1(ListNode list){
        List<Integer> ret=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        while(list!=null){
            stack.push(list.val);
            list=list.next;
        }
        while(!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;

    }
    //使用递归
    public List<Integer> method2(ListNode list){
        List<Integer> res=new ArrayList<>();
        if (list!=null) {
            res.addAll(method2(list.next));
            res.add(list.val);
        }
        return res;
    }

    //头插法，头节点和第一个节点的区别：头节点是在头插法中使用的一个额外的节点，该节点不存储值。第一个节点是链表的第一个真正存储值的节点
    public List<Integer> method3(ListNode listnode){
        ListNode head=new ListNode(-1);
        while(listnode!=null){
            ListNode memo=listnode.next;
            listnode.next=head.next;
            head.next=listnode;
            listnode=memo;
        }
        List<Integer> res=new ArrayList<>();
        head=head.next;
        while(head!=null){
            res.add(head.val);
            head=head.next;
        }
        return res;
    }

    public List<Integer> method4(ListNode listnode){
        List<Integer> res=new ArrayList<>();
        while(listnode!=null){
            res.add(listnode.val);
            listnode=listnode.next;
        }
        Collections.sort(res);
        return res;
    }


}
