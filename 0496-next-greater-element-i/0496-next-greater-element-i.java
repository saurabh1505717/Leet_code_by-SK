class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int []ans=new int[nums1.length];
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> st=new Stack<>();
        
        for(int i:nums2){
            while(!st.isEmpty() &&  i>st.peek()){
                hm.put(st.pop(), i);
            }
            st.push(i);
        }
        
        int j=0;
        for(int num:nums1){
            ans[j++]=hm.getOrDefault(num, -1);
        }
        return ans;
    }
}