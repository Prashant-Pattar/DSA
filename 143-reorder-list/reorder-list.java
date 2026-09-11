/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode current=slow.next;
        ListNode previous=null;
        while(current!=null){
            ListNode next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }

        ListNode second=previous;
        slow.next=null;
        ListNode first=head;

        ListNode firstNext=head.next;
        ListNode secondNext=slow.next;

        while(second!=null){
            firstNext=first.next;
            secondNext=second.next;

            first.next=second;
            second.next=firstNext;

            first=firstNext;
            second=secondNext;
        }

    }
}