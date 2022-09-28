class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer>hm = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            if(hm.containsKey(nums1[i])){
                int of=hm.get(nums1[i]);
                int nf=of+1;
                hm.put(nums1[i],nf);
            }else{
                hm.put(nums1[i],1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<nums2.length; i++){
            if(hm.size()>0 && hm.containsKey(nums2[i])){
                ans.add(nums2[i]);
                int freq=hm.get(nums2[i]);
                if(freq>1){
                    int nf = freq-1;
                    hm.put(nums2[i], nf);
                }else{
                    hm.remove(nums2[i]);
                }
            }
            else{
                continue;
            }
        }
        int[] res = new int[ans.size()];
        for(int i=0; i<res.length; i++){
            int element=ans.get(i);
            res[i]=element;
        }
        return res;
    }
}