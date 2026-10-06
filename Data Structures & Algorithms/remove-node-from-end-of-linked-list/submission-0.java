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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int size =0;
        ListNode temp =head;
        while(temp!=null){
            size+=1;
            temp=temp.next;
        }
        if(size==n){
            return head.next;
        }

        ListNode lastNode=head;
        int j=1;
        while(j<size-n){
            lastNode=lastNode.next;
            j+=1;

        }
        lastNode.next=lastNode.next.next;
        return head;

    }
}
