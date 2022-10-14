/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> set=new HashMap<>();
        if(headA==null||headB==null){
            return null;
        }
        while(headA!=null){
            set.put(headA,headA.val);
            headA=headA.next;
        }
        while(headB!=null){
            if(set.containsKey(headB)){
                return headB;
                // break;
            }
            headB=headB.next;
        }
        return null;
    }
}