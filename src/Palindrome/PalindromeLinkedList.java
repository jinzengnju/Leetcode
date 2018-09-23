package Palindrome;

import List.PrintList;

//Given a singly linked list, determine if it is a palindrome.
//
//        Example 1:
//
//        Input: 1->2
//        Output: false
//        Example 2:
//
//        Input: 1->2->2->1
//        Output: true
//        Follow up:
//        Could you do it in O(n) time and O(1) space?
public class PalindromeLinkedList {
    public static void main(String[] args){

    }
    static class ListNode{
        int val;
        ListNode next;
    }
    public boolean isPalindrome(ListNode head){
        if (head==null&&head.next==null){
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if (fast!=null) slow=slow.next;
        cut(head,slow);
        return isEqual(head,reverse(slow));
    }
    private boolean isEqual(ListNode l1,ListNode l2){
        while (l1!=null&&l2!=null){
            if (l1.val!=l2.val) return false;
            l1=l1.next;
            l2=l2.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode newhead=null;
        while (head!=null){
            ListNode nextnode=head.next;
            head.next=newhead;
            newhead=head;
            head=nextnode;
        }
        return newhead;
    }
    private void cut(ListNode head,ListNode cut){
        while (head.next!=cut){
            head=head.next;
        }
        head.next=null;
    }

}
