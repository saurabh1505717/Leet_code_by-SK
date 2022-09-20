class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int majorityElementLength=n/3;
        HashMap<Integer, Integer>hm=new HashMap<>();
        for(int i=0; i<n; i++){
            if(hm.containsKey(nums[i])){
                int of = hm.get(nums[i]);
                int nf = of+1;
                hm.put(nums[i], nf);
            }else{
                hm.put(nums[i], 1);
            }
        }
        ArrayList<Integer>ans = new ArrayList<>();
        // int i=0;
        for(Integer key:hm.keySet()){
            Integer val = hm.get(key);
            System.out.println(key+" "+val);
            if(majorityElementLength<val){
                ans.add(key);
            }
        }
        return ans;   
    }
}