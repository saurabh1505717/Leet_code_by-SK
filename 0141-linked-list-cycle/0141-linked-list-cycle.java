/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> map=new HashSet<>();
        if(head==null || head.next==null){
            return false;
        }
        while(head!=null){
            if(map.contains(head)){
                return true;
            }
            else{
                map.add(head);
            }
            head=head.next;
        }
        return false;
    }
}