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
        
        ArrayList<Integer> ar=new ArrayList<>();
        ArrayList<Integer> al=new ArrayList<>();
        HashMap<Integer, Integer>hm=new HashMap<>();
        while(head!=null){
            ar.add(head.val);
            head=head.next;
        }
        
        for(int i:ar){
            if(hm.containsKey(i)){
                int of=hm.get(i);
                int nf=of+1;
                hm.put(i,nf);
            }
            else{
                hm.put(i,1);
            }
        }
        
        for(Integer key:hm.keySet()){
            int ele=hm.get(key);
            if(ele==1){
                al.add(key);
            }
        }
        
        Collections.sort(al);
        
        ListNode temp;
        ListNode dummy=new ListNode(5,null);
        temp=dummy;
        for(int val:al){
            // int val=arr[i];
            ListNode val1= new ListNode(val,null);
            temp.next=val1;
            temp=temp.next;
        }
        
        return dummy.next;
    }
}