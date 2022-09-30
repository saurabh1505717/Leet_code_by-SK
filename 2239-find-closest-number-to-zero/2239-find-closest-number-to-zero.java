class Solution {
    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int ans=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(Math.abs(nums[i])<=Math.abs(ans)){
                ans=nums[i];
            }
        }
        return ans;
    }
}