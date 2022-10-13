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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newList=head;
        while(newList!=null && newList.next!=null){
            // if(head.next==null){
            //     break;
            // }
            if(newList.val==newList.next.val){
                newList.next=newList.next.next;
            }
            else{
                newList=newList.next;
            }
            // head=head.next;
        }
        
        return head;
    }
}