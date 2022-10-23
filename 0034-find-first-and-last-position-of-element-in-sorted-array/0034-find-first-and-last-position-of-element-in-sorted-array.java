class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=0, last=0;
        if(nums.length==0){
            return new int[]{-1, -1};
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                first=i;
                break;
            }
            if(i==nums.length-1){
                first=-1;
            }
        }
        
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]==target){
                last=i;
                break;
            }
            if(i==0){
                last=-1;
            }
        }
        return new int[]{first, last};
    }
}