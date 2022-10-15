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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st=new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        ListNode temp=head;
        while(temp!=null){
            st.push(temp.val);
            q.add(temp.val);
            temp=temp.next;
        }
        while(!st.empty() || !q.isEmpty()){
            if(st.peek()!=q.peek()){
                return false;
            }
            st.pop();
            q.remove();
        }
        return true;
    }
}