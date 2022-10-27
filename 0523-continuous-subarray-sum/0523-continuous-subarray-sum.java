class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer>hm=new HashMap<>();
        int currentSum=0, prevSum=0;
        for(int i=0; i<nums.length; i++){
            currentSum=currentSum+nums[i];
            if(hm.containsKey(currentSum%k)){
                return true;
            }
            else{
                currentSum%=k;
                hm.put(prevSum, i);
                prevSum=currentSum;
            }
        }
        return false;
    }
}