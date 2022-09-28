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
        int count = 0;
        ListNode tmp1 = head;
        while(tmp1!=null){
            count++;
            tmp1 = tmp1.next;
        }
        
        if((count==1)&&(n==1))
            return null;
        else if(count==n)
            return head.next;
        
        tmp1 = head;
        count-=(n+1);
        while(count>0){
            count--;
            tmp1 = tmp1.next;
        }
        
        ListNode node = tmp1.next;
        tmp1.next = node.next;
        
        return head;
    }
}