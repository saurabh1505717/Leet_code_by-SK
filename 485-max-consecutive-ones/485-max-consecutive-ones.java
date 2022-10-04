class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int temp=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==1){
                count++;
                    if(temp<count){
                    temp=count;
                    // count=0;
                }
            }
            
            else if(nums[i]!=1){

                count=0;
            }
            // count=0;
        }
        System.out.println(count);
        System.out.println(temp);

        return temp;
    }
}