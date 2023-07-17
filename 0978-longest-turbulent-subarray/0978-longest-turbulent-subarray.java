class Solution {
    public int maxTurbulenceSize(int[] nums) {
        int count1Max = 1;
        int count2Max = 1;
        int count1 = 1;
        int count2 = 1;
        int flag = 0;
        for(int i=1; i<nums.length; i++){
            if((flag==0 && nums[i]<nums[i-1]) || (flag==1 && nums[i]>nums[i-1])){
                count1++;
                count1Max = Math.max(count1Max,count1);
            }else{
                count1 = 1;
            }
            if((flag==0 && nums[i]>nums[i-1]) || (flag==1 && nums[i]<nums[i-1])){
                count2++;
                count2Max = Math.max(count2Max,count2);
            }else{
                count2 = 1;
            }
            flag^=1;
        }
        return Math.max(count1Max,count2Max);  
    }
}