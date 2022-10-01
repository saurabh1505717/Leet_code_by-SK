class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer>hm=new HashMap<>();
        
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i],i);
        }
        
        for(int i=0; i<operations.length; i++){
            int index=hm.get(operations[i][0]);
            nums[index]=operations[i][1];
            
            hm.remove(operations[i][0]);
            hm.put(nums[index], index);
        }
        return nums;
    }
}