class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                int val=hm.get(nums[i]);
                count=count+val;
                hm.put(nums[i],val+1);
            }
            else{
                hm.put(nums[i],1);
            }
        }
        return count;
        
    }
}