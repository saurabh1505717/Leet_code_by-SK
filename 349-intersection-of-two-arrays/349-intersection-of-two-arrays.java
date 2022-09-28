class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            if(hm.containsKey(nums1[i])){
                continue;
            }else{
                hm.put(nums1[i],1);
            }
        }
        int j=0;
        ArrayList<Integer>ans=new ArrayList<>();
        
        for(int i=0; i<nums2.length; i++){
            if(hm.containsKey(nums2[i]) && hm.size()>0){
                ans.add(nums2[i]);
                hm.remove(nums2[i]);
            }
            else{
                continue;
            }
        }
        int[] res=new int[ans.size()];
        for(Integer i=0; i<ans.size(); i++){
            int element=ans.get(i);
            res[i]=element;
        }
        return res;
    }
}