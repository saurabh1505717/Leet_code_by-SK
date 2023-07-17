class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long max=0, currSum=0;
        int n=nums.length;
        HashMap<Integer, Integer>hm=new HashMap<>();

        for(int i=0; i<k; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
            currSum+=(long)nums[i];
        }

        if(hm.size()==k){
            max=currSum;
        }

        int left=0;
        for(int i=k; i<n; i++){
            currSum-=(long)nums[left];
            currSum+=(long)nums[i];

            hm.put(nums[left], hm.get(nums[left])-1);
            if(hm.get(nums[left])==0){
                hm.remove(nums[left]);
            }

            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
            left++;
            if(hm.size()==k){
                max=Math.max(max, currSum);
            }
        }
        
        return max;
    }
}